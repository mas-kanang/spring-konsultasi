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
    @Column(name="kode",length = 10, nullable = false)
    private String id;

    @Column(name="nama_layanan",length = 100, nullable = false)
    private String namaLayanan;

    @Column(name="keterangan",length = 100, nullable = true)
    private String keterangan;

    @Column(name="kode_kantor")
    private String kodeKantor = "070100";

    @Column(name="kode_unit_organisasi")
    private String kodeUnitOrganisasi = "35062607";
}
