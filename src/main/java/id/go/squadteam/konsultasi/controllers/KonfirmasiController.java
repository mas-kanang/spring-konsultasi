package id.go.squadteam.konsultasi.controllers;

import id.go.squadteam.konsultasi.models.entities.Konfirmasi;
import id.go.squadteam.konsultasi.models.entities.Pengajuan;
import id.go.squadteam.konsultasi.models.repository.KonfirmasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/konfirmasi")
public class KonfirmasiController {
    @Autowired
    private KonfirmasiRepository konfirmasiRepository;

    @GetMapping
    public List<Konfirmasi> findAll() {
        return konfirmasiRepository.findAll();
    }


    @PostMapping
    public ResponseEntity< ? > save(@RequestBody Konfirmasi konfirmasi){
        if ( konfirmasi.getCar() == null || konfirmasi.getImportir() == null
                || konfirmasi.getPpjk() == null || konfirmasi.getType() == null
                || konfirmasi.getCar().equals("") || konfirmasi.getImportir().equals("")
                || konfirmasi.getPpjk().equals("")  || konfirmasi.getType().equals("") ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data tidak lengkap");
        } else {
            konfirmasiRepository.save(konfirmasi);
            return ResponseEntity.ok("Success");
        }
    }

    @PutMapping
    public ResponseEntity< ? > update(@RequestBody Konfirmasi konfirmasi){
        if ( konfirmasi.getCar() == null || konfirmasi.getImportir() == null
                || konfirmasi.getPpjk() == null || konfirmasi.getType() == null
                || konfirmasi.getCar().equals("") || konfirmasi.getImportir().equals("")
                || konfirmasi.getPpjk().equals("")  || konfirmasi.getType().equals("") ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data tidak lengkap");
        } else {
            konfirmasiRepository.save(konfirmasi);
            return ResponseEntity.ok("Success");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > detail(@PathVariable long id){
        Optional<Konfirmasi> konfirmasi = konfirmasiRepository.findById(id);
        if (konfirmasi.isPresent()){
            return ResponseEntity.ok(konfirmasi);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not valid");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity< ? > delete(@PathVariable long id){
        Optional<Konfirmasi> konfirmasi = konfirmasiRepository.findById(id);
        if (konfirmasi.isPresent()){
            konfirmasiRepository.deleteById(id);
            return ResponseEntity.ok("Delete Success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Fail");
        }
    }
}
