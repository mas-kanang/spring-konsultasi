package id.go.squadteam.konsultasi.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "konfirmasi")
@Data
@NoArgsConstructor
public class Konfirmasi {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aju")
    @SequenceGenerator(name="seq_aju", sequenceName="seq_aju", allocationSize=1)
    private long id;

    @Column(name="car", length = 100, nullable = false)
    private String car;

    @Column(name="importir", length = 100, nullable = false)
    private String importir;

    @Column(name="ppjk", length = 100, nullable = false)
    private String ppjk;

    @Column(name="type", length = 100, nullable = false)
    private String type = "IMP";

}
