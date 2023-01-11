package id.go.squadteam.konsultasi.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String Status = "Kirim";

    @Column(name="nip_rekam")
    private String nipRekam;

    @Column(name="nama_pegawai_rekam")
    private String namaPegawaiRekam;

    @CreationTimestamp
    @Column(name="waktu_rekam")
    private LocalDateTime waktuRekam;

    @Column(name="nip_update")
    private String nipUpdate;

    @Column(name="nama_pegawai_update")
    private String namaPegawaiUpdate;

    @UpdateTimestamp
    @Column(name="waktu_update")
    private LocalDateTime waktuUpdate;

    @Column(name="fl_active")
    private String flActive = "Y";
}
