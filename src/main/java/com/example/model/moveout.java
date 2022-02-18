    package com.example.model;

    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.hibernate.annotations.GenericGenerator;
    import org.hibernate.validator.constraints.NotEmpty;
    import org.springframework.format.annotation.DateTimeFormat;

    import javax.persistence.*;
    import javax.validation.constraints.Size;
    import java.util.Date;


    @Getter @Setter @NoArgsConstructor
    @Table(name = "moveout")
    @Entity
    public class moveout
    {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_moveout", unique = true, nullable = false)
    String id_moveout;

//    @JoinColumn(name = "id_spare_part")
//    @ManyToOne
//    private spare_part id_spare_part;

    @NotEmpty
    @Size(min=1, max=30)
    String kode_moveout;

    @NotEmpty
    @Size(min=1, max=30)
    String kode_spare_part;

    @NotEmpty
    String keterangan;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="tgl_moveout", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date tgl_moveout;

    int jumlah;

        @NotEmpty
        @Size(min=1, max=30)
        String harga;

        @NotEmpty
        @Size(min=1, max=30)
        String total;
    }
