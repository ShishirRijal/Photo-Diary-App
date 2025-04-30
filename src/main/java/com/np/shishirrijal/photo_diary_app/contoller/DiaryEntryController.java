package com.np.shishirrijal.photo_diary_app.contoller;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
 import com.np.shishirrijal.photo_diary_app.service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/diaries")
public class DiaryEntryController {

    @Autowired
    DiaryEntryService diaryEntryService;

    @PostMapping
    public DiaryEntry createPhotoEntry(@RequestBody DiaryEntry diaryEntry) {
        return diaryEntryService.createPhotoEntry(diaryEntry);
    }

    @GetMapping
    public List<DiaryEntry> getAllPhotoEntries() {
        System.out.println(diaryEntryService.getAllPhotoEntries());
        return diaryEntryService.getAllPhotoEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getDiaryEntryWithUser(@PathVariable Long id) {
        DiaryEntry diaryEntry = diaryEntryService.getDiaryEntryWithUser(id);
        return ResponseEntity.ok(diaryEntry);
    }

}
