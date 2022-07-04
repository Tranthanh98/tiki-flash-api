package com.tiki.tikiFlash.infrastructures.repositories;

import com.tiki.tikiFlash.infrastructures.entities.VideoLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLikeRepository extends JpaRepository<VideoLikeEntity, Long> {
}
