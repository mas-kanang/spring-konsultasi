package id.go.squadteam.konsultasi.models.controllers;

import id.go.squadteam.konsultasi.models.entities.Pengajuan;
import id.go.squadteam.konsultasi.models.repository.PengajuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/konsultasi/pengajuan")
public class PengajuanController {
    @Autowired
    private PengajuanRepository pengajuanRepository;

    @GetMapping
    public List<Pengajuan> findAll() {
        return pengajuanRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity< ? > save(@RequestBody Pengajuan pengajuan){
        pengajuanRepository.save(pengajuan);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity< ? > delete(@PathVariable long id){
        Optional<Pengajuan> pengajuan = pengajuanRepository.findById(id);
        if (pengajuan.isPresent()){
            pengajuanRepository.deleteById(id);
            return ResponseEntity.ok("Delete Success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Fail");
        }
    }

    @PostMapping("/detail/{id}")
    public ResponseEntity< ? > detail(@PathVariable long id){
        Optional<Pengajuan> pengajuan = pengajuanRepository.findById(id);
        if (pengajuan.isPresent()){
            return ResponseEntity.ok(pengajuan);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not valid");
        }
    }

    @PostMapping("/search/{page}")
    public ResponseEntity< ? > search(@PathVariable int page, @RequestParam String perusahaan){
        Pageable pageAndSort = PageRequest.of(page > 0 ? page - 1 : page, 10, Sort.by("perusahaan").ascending());
        List< Pengajuan > pengajuans = pengajuanRepository.findByPerusahaanContainingIgnoreCase(perusahaan,pageAndSort);
        return ResponseEntity.ok(pengajuans);
    }


}
