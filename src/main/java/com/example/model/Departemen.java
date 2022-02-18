package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Audited

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Departemen
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_dept", unique = true, nullable = false)
    String id_dept;

    @Column(unique=true)
    String nama_dept;

    @Column(unique=true)
    String kode_dept;
}
