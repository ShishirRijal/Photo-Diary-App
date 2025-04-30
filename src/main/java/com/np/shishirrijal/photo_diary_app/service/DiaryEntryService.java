package com.np.shishirrijal.photo_diary_app.service;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
import com.np.shishirrijal.photo_diary_app.model.User;
import com.np.shishirrijal.photo_diary_app.repository.DiaryEntryRepository;
import com.np.shishirrijal.photo_diary_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DiaryEntryService {

    @Autowired
    DiaryEntryRepository diaryEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;


     public DiaryEntry createPhotoEntry(DiaryEntry diary) {
         return diaryEntryRepository.save(diary);
     }

    public DiaryEntry createDiaryEntry(Long userId, String description, MultipartFile photo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String photoPath = fileStorageService.saveFile(photo);

        DiaryEntry entry = new DiaryEntry();
        entry.setDescription(description);
        entry.setImageUrl(photoPath);

        entry.setUser(user);

        return diaryEntryRepository.save(entry);
    }


     public List<DiaryEntry> getAllPhotoEntries() {
        return diaryEntryRepository.findAll();
    }

     public DiaryEntry getPhotoEntry(Long id) {
        return diaryEntryRepository.findById(id).orElse(null);
     }

    public DiaryEntry getDiaryEntryWithUser(Long id) {
        return diaryEntryRepository.findByIdWithUser(id); // Fetches both DiaryEntry and User
    }

    public DiaryEntry updateDiaryEntry(Long id, DiaryEntry updatedEntry) {
        DiaryEntry existingEntry = diaryEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));

        existingEntry.setDescription(updatedEntry.getDescription());
        existingEntry.setMood(updatedEntry.getMood());
        existingEntry.setVisibility(updatedEntry.getVisibility());
        existingEntry.setTags(updatedEntry.getTags());
        // You can add other fields as necessary

        return diaryEntryRepository.save(existingEntry);
    }



    public void deleteDiaryEntry(Long id) {
        DiaryEntry existingEntry = diaryEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
        diaryEntryRepository.delete(existingEntry);
    }



    public List<DiaryEntry> getDiaryEntriesByUser(Long userId) {
        return diaryEntryRepository.findByUserId(userId); // Add this query in the repository
    }
    public List<DiaryEntry> searchDiaryEntries(String mood, String tags) {
        return diaryEntryRepository.findByMoodOrTags(mood, tags); // Add this query in the repository
    }


    public List<DiaryEntry> getDiaryEntriesByDateRange(LocalDate startDate, LocalDate endDate) {
        return diaryEntryRepository.findByCreatedAtBetween(startDate, endDate); // Add this query in the repository
    }


}
