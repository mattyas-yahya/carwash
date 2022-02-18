package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "work_orders_aud")
public class work_orders_aud
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_wo_aud", unique = true, nullable = false)
  String id_wo_aud;
  @JoinColumn(name = "id_tr_asset")
  @ManyToOne
  Tr_asset id_tr_asset;
  @JoinColumn(name = "id_dept")
  @ManyToOne
  Departemen id_dept ;
  @Column(name = "kode_wo", unique = true, nullable = false)
  String kode_wo;
  /////////////////// milik department/////////////////
  String nama_dept;



  /////////////////// milik department/////////////////
  @Size( max=1000)
  String title;
  /////////////////// milik asset/////////////////
  String kode_asset;
  String lokasi;
  ////////////////////////////////////////////////
  String status_pekerjaan;
  String prioritas;


  @Size( max=1000)
  String solution;
  String jenis_pekerjaan;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="pembuatan", nullable=true)
  @Temporal(TemporalType.DATE)
  private Date pembuatan;
  private double setup;
  private double breakdown;



  ///product
//  @Column(unique = true)
  String batch_no;
  String product_name;
  String Quantity;
  String UOM;
  //////////////

  double mtbf;
  double mttr;
  //oee//
  double work_time;
  double cycle_time;
  double good_pieces;
  double uptime;
  double downtime;


  ////oee
  double AR;//(work_time-downtime/work_time) x100
  double PR;//(Quantity/work_time x cycle_time ) x 100
  double QR;//(good_pieces / Quantity) x 100

}
