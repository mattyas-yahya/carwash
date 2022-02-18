package com.example.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bom
{
  @Id
//  @Column(length = 35,name = "id_bom",updatable = false, nullable = false)
//  private UUID id_bom=UUID.randomUUID();
////  @Id
////  @GeneratedValue(generator = "uuid2")
////  @GenericGenerator(name="uuid2",strategy = "uuid2")
////  @Column(length = 35,name = "id_bom",updatable = false, nullable = false)
////  private String id_bom;

    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "id_bom", unique = true, nullable = false)  Long id_bom;
  String id_inventory;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="create_date", nullable=false)
  @Temporal(TemporalType.DATE)
  private Date create_date;
  String kode_bom;
  String kode_formula;
  String formula_name;
  String kode_Items;
  int proposal;
  String UOM;
  int consume;
  int subtotal;
  String note;
}
