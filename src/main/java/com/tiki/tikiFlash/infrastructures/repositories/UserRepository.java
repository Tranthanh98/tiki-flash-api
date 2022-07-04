package com.tiki.tikiFlash.infrastructures.repositories;

import com.tiki.tikiFlash.infrastructures.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
