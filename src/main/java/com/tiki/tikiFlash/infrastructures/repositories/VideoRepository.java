package com.tiki.tikiFlash.infrastructures.repositories;

import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
}
