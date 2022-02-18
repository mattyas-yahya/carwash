package com.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PreventiveMaintenance")
public class PreventiveMaintenance {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_pm", unique = true, nullable = false)
  private String id_pm;

  @JoinColumn(name = "id_tr_asset")
  @ManyToOne
  Tr_asset id_tr_asset;

  @NotEmpty
  String kode_pm;

  @NotEmpty
  @Size(min = 1, max = 30)
  String kode_asset;

  @NotEmpty
  String deskripsi;

  int man_power;

  int lead_time;

 // String status;//wip.aprove.end

  //////////frequency
//time base
  int frequency;

  String freq_unit;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "pembuatan", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date next_due_date;//servis selanjutnya


  /////////////work order infotmation
  String wo_type; //calibration,corective maintenance,event report,preventive maintenan,capital_project,

  String location;

}
