package com.tiki.tikiFlash.infrastructures.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "video")
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity extends BaseAuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    private String title;

    @Column(nullable = false)
    long size;

    @Column(nullable = false, length = 10)
    String extension;

    @Column(nullable = false)
    String userId;

    @Column(nullable = false)
    String s3Key;

    @Column(nullable = false)
    Boolean isActive = true;

    @Column(nullable = false)
    Integer totalView = 0;
}
