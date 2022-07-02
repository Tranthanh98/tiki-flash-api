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
@Table(name = "test-table")
@AllArgsConstructor
@NoArgsConstructor
public class TestTable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
