package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@Data
@Entity
@Table(name = "header_pr")
public class header_pr
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_header_pr", unique = true, nullable = false)
String id_header_pr;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="req_tanggal", nullable=true)
  @Temporal(TemporalType.DATE)
  private Date req_tanggal;
  @Column(name = "kode_pr", unique = true, nullable = false)
  String kode_pr;
  String jenis_pr;
  String status;

}
