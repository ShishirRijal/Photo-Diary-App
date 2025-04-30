package com.np.shishirrijal.photo_diary_app.repository;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {

    @Query("SELECT de FROM DiaryEntry de JOIN FETCH de.user WHERE de.id = :id")
    DiaryEntry findByIdWithUser(@Param("id") Long id);

    public List<DiaryEntry> findByUserId(Long userId);

    @Query("SELECT de FROM DiaryEntry de WHERE de.mood = :mood OR de.tags LIKE %:tags%")
    List<DiaryEntry> findByMoodOrTags(@Param("mood") String mood, @Param("tags") String tags);

    List<DiaryEntry> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);

}
