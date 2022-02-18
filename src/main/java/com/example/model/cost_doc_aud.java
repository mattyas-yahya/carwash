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

public class cost_doc_aud
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_cost_doc_aud", unique = true, nullable = false)
  String id_cost_doc_aud;
  String id_cost_doc;
  String  id_wo_pm;
  String  id_inv_org;
  String kode;///wo / pm
  String issue;///

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="pembuatan", nullable=true)
  @Temporal(TemporalType.DATE)
  private Date pembuatan;
  String Account;
  String status;//validate(masih estimasi sementara) / post (sudah fix tidak bisa di edit)
  String cost_doc_type; ///invoice,receipt,material record, man hour record
String item;//nama_pekerja/ kode_inventory
int quantity; //untuk _inventory
  int cost; //untuk _inventory/manual biaya pekerja
  int total; //untuk _inventory/pekerja


}
