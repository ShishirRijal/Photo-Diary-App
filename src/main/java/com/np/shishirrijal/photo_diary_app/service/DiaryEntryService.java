package com.np.shishirrijal.photo_diary_app.service;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
import com.np.shishirrijal.photo_diary_app.repository.DiaryEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class DiaryEntryService {

    DiaryEntryRepository diaryEntryRepository;


     public DiaryEntry createPhotoEntry(@RequestBody DiaryEntry diary) {
         return diaryEntryRepository.save(diary);
     }

     public List<DiaryEntry> getAllPhotoEntries() {
        return diaryEntryRepository.findAll();
    }

     public DiaryEntry getPhotoEntry(@PathVariable UUID id) {
        return diaryEntryRepository.findById(id).orElse(null);
     }

}
