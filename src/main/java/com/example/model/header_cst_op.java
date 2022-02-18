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
public class header_cst_op
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_header_cst_op", unique = true, nullable = false)
String id_header_cst_op;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="date", nullable=false)
  @Temporal(TemporalType.DATE)
  private Date date;

  String reference;

  String descrip;

  String status;
}
