package id.go.squadteam.konsultasi.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "konfirmasi_jawaban")
@Data
@NoArgsConstructor
public class KonfirmasiJawaban {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jawab")
    @SequenceGenerator(name="seq_jawab", sequenceName="seq_jawab", allocationSize=1)
    private long id;

    @Column(name="konfirmasi_id", length = 100, nullable = false)
    private String konfirmasi_id;

    @Column(name="uraian", length = 1000, nullable = false)
    private String uraian;

    @Column(name="status", length = 100, nullable = false)
    private String status;

}
