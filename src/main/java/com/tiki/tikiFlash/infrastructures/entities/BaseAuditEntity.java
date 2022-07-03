package com.tiki.tikiFlash.infrastructures.entities;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
public class BaseAuditEntity {
    @Column(nullable = false)
    protected OffsetDateTime createdDate = OffsetDateTime.now(ZoneOffset.UTC);

    @PrePersist
    protected void onCreated(){
        createdDate = OffsetDateTime.now(ZoneOffset.UTC);
    }

}
