package com.np.shishirrijal.photo_diary_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String imageUrl;
    private String description;
    private String mood;  // e.g., Happy, Sad
    private String visibility;

    private String tags;

    private String createdAt;
}
