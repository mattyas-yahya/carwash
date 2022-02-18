package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "header_moveout")
public class header_moveout
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_header_moveout", unique = true, nullable = false)
String id_header_moveout;
    @NotEmpty
String referensi;
    @NotEmpty
String deskripsi;
    @NotEmpty
    String stat_transaction;
}
