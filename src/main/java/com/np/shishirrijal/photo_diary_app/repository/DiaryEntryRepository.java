package com.np.shishirrijal.photo_diary_app.repository;

import com.np.shishirrijal.photo_diary_app.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {

    @Query("SELECT de FROM DiaryEntry de JOIN FETCH de.user WHERE de.id = :id")
    DiaryEntry findByIdWithUser(@Param("id") Long id);

}
