package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor

@Entity
public class TakeOver
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_take_over", unique = true, nullable = false)
String id_take_over;

    @JoinColumn(name ="id_wo")
    @ManyToOne
   private work_orders id_wo;

    @Column(unique=true)
String kode_TO;

    @Column(unique=true)
    String kode_wo;

    @Size( max=9000)
    String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="start", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="end")
    @Temporal(TemporalType.DATE)
    private Date end;

    String vendor_asal;

    String vendor_baru;

}
