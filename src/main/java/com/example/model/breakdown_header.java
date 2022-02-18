package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "breakdown_header")
public class breakdown_header
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_breakdown_header", unique = true, nullable = false)
    String id_breakdown_header;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="tanggal", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    String reference;
    String deskripsi;
}
