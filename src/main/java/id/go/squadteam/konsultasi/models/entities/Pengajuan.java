package id.go.squadteam.konsultasi.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pengajuan")
@Data
@NoArgsConstructor
public class Pengajuan {
    @Id
    @Column(name = "id_pengajuan")
    private long id;

    @Column(name="npwp")
    private String npwp;

    @Column(name="nama_pic")
    private String namaPic;

    @Column(name="perusahaan")
    private String perusahaan;

    @Column(name="kode_layanan")
    private String kodeLayanan;

    @Column(name="nomor_tiket")
    private String nomorTiket;

    @Column(name="status")
    private String Status;
}
