package com.np.shishirrijal.photo_diary_app.repository;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, UUID> {
}
