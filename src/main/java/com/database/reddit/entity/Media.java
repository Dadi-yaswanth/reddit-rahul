package com.database.reddit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "media_tbl")
@Setter
@Getter
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long mediaId;

    private String pathUrl;

    @Column(name = "is_video")
    private boolean isVideo;

    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", pathUrl='" + pathUrl + '\'' +
                ", isVideo=" + isVideo +
                '}';
    }
}
