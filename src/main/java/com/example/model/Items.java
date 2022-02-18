package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Items
{

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  String id_Items;
  @JoinColumn(name = "id_vendor")
  @ManyToOne
  vendor id_vendor;
  @Column private String kode_Items;
  @NotEmpty  @Size(min=0, max=30)  private String serial;//serial / batch number
  @Column(name = "nama_Items", unique = true, nullable = false)
  private String nama_Items;
  private String model;
  String jenis;//oil,dll
  String uom;//pcs,kg dll
  Double harga;
  @NotEmpty  String vendor_name;
  @DateTimeFormat(pattern = "yyyy-MM-dd")  @Column(name="purch_date", nullable=false)  @Temporal(TemporalType.DATE)  private Date purchase_date;

}
