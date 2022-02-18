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

public class pekerja
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_pekerja", unique = true, nullable = false)
String id_pekerja;
  @JoinColumn(name ="id_plant")
  @ManyToOne
  private plant id_plant;

String nama_lengkap;
String nama_panggilan;
String Alamat;
String Status_pernikahan;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="tgl_lahir")
  @Temporal(TemporalType.DATE)
  private Date tgl_lahir;


  //emp inf
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="tgl_masuk_kerja")
  @Temporal(TemporalType.DATE)
  private Date tgl_masuk_kerja;
  String jabatan;
  String code_jabatan;
  String stat_pegawai; //kontrak
  String code_plant;
  String status; //active opo gak
}
