package id.go.squadteam.konsultasi.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pengajuan")
@Data
@NoArgsConstructor
public class Pengajuan {
    @Id
    @Column(name = "id_pengajuan")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_aju")
    @SequenceGenerator(name="seq_aju", sequenceName="seq_aju", allocationSize=1)
    private long id;

    @Column(name="npwp", length = 100, nullable = false)
    private String npwp;

    @Column(name="nama_pic", length = 100, nullable = false)
    private String namaPic;

    @Column(name="perusahaan", length = 100, nullable = false)
    private String perusahaan;

    @Column(name="kode_layanan", length = 100, nullable = false)
    private String kodeLayanan;

    @Column(name="nomor_tiket", length = 100, nullable = true)
    private String nomorTiket;

    @Column(name="status", length = 100, nullable = true)
    private String Status;
}
