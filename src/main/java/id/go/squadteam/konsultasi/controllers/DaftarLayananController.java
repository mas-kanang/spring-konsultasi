package id.go.squadteam.konsultasi.controllers;

import id.go.squadteam.konsultasi.models.entities.DaftarLayanan;
import id.go.squadteam.konsultasi.models.entities.Pengajuan;
import id.go.squadteam.konsultasi.models.repository.DaftarLayananRepository;
import id.go.squadteam.konsultasi.models.repository.PengajuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/konsultasi/daftar_layanan")
public class DaftarLayananController {

    @Autowired
    private DaftarLayananRepository daftarLayananRepository;
    @Autowired
    private PengajuanRepository pengajuanRepository;

    @GetMapping
    public List<DaftarLayanan> findAll(){return daftarLayananRepository.findAll();}

    @PostMapping("/delete/{id}")
    public ResponseEntity< ? > delete(@PathVariable String id){
        DaftarLayanan daftarLayanan = daftarLayananRepository.findById(id);
         if (daftarLayanan == null) {
             return ResponseEntity.ok("Layanan tidak ditemukan");
        } else {
             List< Pengajuan > pengajuan = pengajuanRepository.findByKodeLayanan(id);
             if (pengajuan.size() == 0) {
                 daftarLayananRepository.delete(daftarLayanan);
                 return  ResponseEntity.ok("Success");
             } else {
                 return  ResponseEntity.ok("Layanan sudah digunakan, tidak bisa di Delete");
             }
        }
    }

    @PostMapping("/save")
    public ResponseEntity< ? > save(@RequestBody DaftarLayanan daftarLayanan){
        if ( daftarLayanan.getId() == null || daftarLayanan.getNamaLayanan() == null
                || daftarLayanan.getKeterangan() == null || daftarLayanan.getId().equals("")
                || daftarLayanan.getNamaLayanan().equals("") || daftarLayanan.getKeterangan().equals("") ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data tidak lengkap");
        } else {
            daftarLayananRepository.save(daftarLayanan);
            return ResponseEntity.ok("Success");
        }
    }
}
