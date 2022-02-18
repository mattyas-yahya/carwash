package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class jadwal
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_jadwal", unique = true, nullable = false)
    private String id_jadwal;

  @JoinColumn(name = "id_pm")
  @ManyToOne
  PreventiveMaintenance id_pm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="start")
    @Temporal(TemporalType.DATE)
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="end")
    @Temporal(TemporalType.DATE)
    private Date end;

    private String kode_pm;
    private String title;
  private String location;
    private String status;
    private String color;
}
