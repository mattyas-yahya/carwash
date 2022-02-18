package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class project_material
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_project_material", unique = true, nullable = false)
String id_project_material;

  @JoinColumn(name = "id_header_cst_pro")
  @ManyToOne
  private header_cst_pro id_header_cst_pro;

  @JoinColumn(name = "id_inventory")
  @ManyToOne
  private inventaris id_inventory;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="date", nullable=false)
  @Temporal(TemporalType.DATE)
  private Date date;

  String reference;

  String descrip;


  String Material_code;
  String Material_name;
  double quantity;
  String UOM;
  double cost;
  double subtotal_cost;

  String Account;

}
