package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class OnHandStok
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_OnHandStok", unique = true, nullable = false)
String id_OnHandStok;

  @JoinColumn(name = "id_asset")
  @ManyToOne
 Asset id_asset;

  @NotEmpty
  private String asset_code;

  @NotEmpty
  @Size(min=0, max=30)
  private String asset_name;

  private int begin_balance;
  private int transfer;
  private int consume;
  private int adjustment;
  private int end_balance;
}
