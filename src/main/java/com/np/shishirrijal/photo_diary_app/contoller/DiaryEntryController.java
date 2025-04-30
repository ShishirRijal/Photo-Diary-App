package com.np.shishirrijal.photo_diary_app.contoller;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
 import com.np.shishirrijal.photo_diary_app.service.DiaryEntryService;
import com.np.shishirrijal.photo_diary_app.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/diaries")
public class DiaryEntryController {

    @Autowired
    DiaryEntryService diaryEntryService;

    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping
    public ResponseEntity<DiaryEntry> createPhotoEntry(@RequestBody DiaryEntry diaryEntry) {
        DiaryEntry saved = diaryEntryService.createPhotoEntry(diaryEntry);
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public ResponseEntity<List<DiaryEntry>> getAllPhotoEntries() {
         return ResponseEntity.ok(diaryEntryService.getAllPhotoEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getDiaryEntryWithUser(@PathVariable Long id) {
        DiaryEntry diaryEntry = diaryEntryService.getDiaryEntryWithUser(id);
        return ResponseEntity.ok(diaryEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntry> updateDiaryEntry(@PathVariable Long id, @RequestBody DiaryEntry updatedEntry) {
        DiaryEntry entry = diaryEntryService.updateDiaryEntry(id, updatedEntry);
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaryEntry(@PathVariable Long id) {
        diaryEntryService.deleteDiaryEntry(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public List<DiaryEntry> getDiaryEntriesByUser(@PathVariable Long userId) {
        return diaryEntryService.getDiaryEntriesByUser(userId);
    }

    @GetMapping("/search")
    public List<DiaryEntry> searchDiaryEntries(
            @RequestParam(required = false) String mood,
            @RequestParam(required = false) String tags
    ) {
        return diaryEntryService.searchDiaryEntries(mood, tags);
    }

    @GetMapping("/date-range")
    public List<DiaryEntry> getDiaryEntriesByDateRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate
    ) {
        return diaryEntryService.getDiaryEntriesByDateRange(startDate, endDate);
    }





}
