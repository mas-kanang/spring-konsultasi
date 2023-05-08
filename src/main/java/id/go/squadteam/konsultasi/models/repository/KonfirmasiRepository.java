package id.go.squadteam.konsultasi.models.repository;

import id.go.squadteam.konsultasi.models.entities.Konfirmasi;
import id.go.squadteam.konsultasi.models.entities.Pengajuan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KonfirmasiRepository extends JpaRepository<Konfirmasi, Long> {
}
