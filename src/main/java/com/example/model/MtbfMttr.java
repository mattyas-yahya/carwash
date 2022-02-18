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
public class MtbfMttr
{
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(name = "Id_MtbfMttr", unique = true, nullable = false)
String Id_MtbfMttr;

//@JoinColumn(name = "id_spare_part")
//@ManyToOne
//private spare_part id_spare_part;

    @JoinColumn(name = "id_breakdown_header")
    @ManyToOne
    private breakdown_header id_breakdown_header;

    String reference;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="tgl_", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date tgl;

    String kode_asset;
    String kode_spare_part;


double uptime;
double down_time;
double quantity_troble;

double mtbf;
double mttr;

}
