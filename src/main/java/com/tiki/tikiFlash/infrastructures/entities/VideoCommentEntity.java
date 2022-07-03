package com.tiki.tikiFlash.infrastructures.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "video_comment")
@AllArgsConstructor
@NoArgsConstructor
public class VideoCommentEntity extends BaseAuditEntity{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Long videoId;
}
