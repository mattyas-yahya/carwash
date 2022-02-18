package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter @Setter @NoArgsConstructor
@Entity
@Audited

@Table(name = "asset")
public class Asset
{
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(name = "id_asset", unique = true, nullable = false)
 String id_asset;



  @JoinColumn(name = "id_vendor")
  @ManyToOne
  private vendor  id_vendor;

@NotEmpty
@Size(min=0)
private String asset_name;

  @NotEmpty
  @Size(min=0, max=30)
  private String serial;

  @Column(name = "asset_code", unique = true, nullable = false)
private String asset_code;

private String parent_code;

@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name="purch_date", nullable=false)
@Temporal(TemporalType.DATE)
private Date purchase_date;

@NotEmpty
private String grup;
@NotEmpty
private String model;
//@NotEmpty
//private String location;

@NotEmpty
private String asset_tag;
private double Price;
private double warranty;
//@NotEmpty
//String safety_referensi;
@NotEmpty
String vendor_name;
//  @NotEmpty
//  String status;
  String reason;
private int consume;
private int stok;
private int end_balance;

}


