package id.go.squadteam.konsultasi.models.repository;

import id.go.squadteam.konsultasi.models.entities.Pengajuan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PengajuanRepository  extends JpaRepository<Pengajuan, Long> {
    public List< Pengajuan > findByPerusahaanContainingIgnoreCase(String perusahaan, Pageable pageable);
}
