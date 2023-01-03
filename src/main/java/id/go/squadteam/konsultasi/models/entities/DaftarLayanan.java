package id.go.squadteam.konsultasi.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daftar_layanan")
@Data
@NoArgsConstructor
public class DaftarLayanan {
    @Id
    @Column(name = "id_layanan")
    private long id;

    @Column(name="kode")
    private String kode;

    @Column(name="nama_layanan")
    private String namaLayanan;

    @Column(name="keterangan")
    private String keterangan;
}
