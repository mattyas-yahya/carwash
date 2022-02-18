package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Audited

@Entity
public class vendor
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_vendor", unique = true, nullable = false)
String id_vendor;
String vendor_ref;
  @Column(name = "vendor_name", unique = true, nullable = false)
String vendor_name;
String vendor_address;
String contact_person;
String phone;
  String note;
}
