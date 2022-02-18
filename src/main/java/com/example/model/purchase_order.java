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
public class purchase_order
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_purchase_order", unique = true, nullable = false)
  String id_purchase_order;

  @JoinColumn(name = "id_pr_req")
  @ManyToOne
  purc_req id_pr_req;

  @JoinColumn(name = "id_header_pr")
  @ManyToOne
  header_pr id_header_pr;


  String no_po;
  String jenis_po;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="po_date", nullable=true)
  @Temporal(TemporalType.DATE)
  private Date po_date;


  String item;
  @Size(max=90)
  String deskripsi;
  int qty;
  String satuan;
  int harga;
  int tax;
  int sub_total;
}
