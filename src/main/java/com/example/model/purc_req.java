package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class purc_req
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_pr_req", unique = true, nullable = false)
  String id_pr_req;

  @JoinColumn(name = "id_header_pr")
  @ManyToOne
  private header_pr id_header_pr;

  String id_item;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="req_tanggal", nullable=true)
  @Temporal(TemporalType.DATE)
  private Date req_tanggal;


  String kode_pr;

  String jenis_pr;

  String status;


  String item;// kode item / nama barang kalo tidak ada datanya

  @Size(max=90)
  String deskripsi;

  int qty;

  String satuan;

@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name="required_date", nullable=true)
@Temporal(TemporalType.DATE)
private Date required_date;

  @Size( max=90)
String note;


}
