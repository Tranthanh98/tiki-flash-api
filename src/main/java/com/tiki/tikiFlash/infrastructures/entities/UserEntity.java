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
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseAuditEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    private String avatar;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
}
