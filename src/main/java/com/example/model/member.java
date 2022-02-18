package com.example.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@Entity

public class member {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_member", unique = true, nullable = false)
  String id_member;
  @Column(name = "kode", unique = true, nullable = false)
  String kode;
  String nama;
  String alamat;


}
