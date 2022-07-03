package com.tiki.tikiFlash.infrastructures.repositories;

import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    Collection<VideoEntity> findAllByUserId(String userId);
}
