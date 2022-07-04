package com.tiki.tikiFlash.infrastructures.repositories;

import com.tiki.tikiFlash.infrastructures.entities.VideoCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCommentRepository extends JpaRepository<VideoCommentEntity, Long> {
}
