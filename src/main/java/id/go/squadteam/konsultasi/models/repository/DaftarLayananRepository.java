package id.go.squadteam.konsultasi.models.repository;

import id.go.squadteam.konsultasi.models.entities.DaftarLayanan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaftarLayananRepository extends JpaRepository<DaftarLayanan, Long> {
    public DaftarLayanan findById(String id);
}
