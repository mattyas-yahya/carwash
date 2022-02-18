package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "failur")
public class failur
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_failur", unique = true, nullable = false)
String id_failur;
    @JoinColumn(name = "id_wo")
    @ManyToOne
    work_orders id_wo ;
    String referensi;
    @Column(unique=true)
    String kode_wo;
    String kode_asset;

    @Size( max=1000)
    String PotentialFailureMode;

    @Size( max=9000)
    String p_effect;

    @Size( max=1000)
    String PotentialCauseMechanismFailure;

    @Size( max=1000)
    String CurrentDesignControls;

    int severity;
    int occurance;
    int detection;
int rpn;
}
