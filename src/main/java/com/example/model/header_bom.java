package com.example.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class header_bom
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_header_bom", unique = true, nullable = false)
String id_header_bom;
String kode_bom;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="create_date", nullable=false)
  @Temporal(TemporalType.DATE)
  private Date create_date;
  String kode_formula;
  int Quantity;
  String note;
}
