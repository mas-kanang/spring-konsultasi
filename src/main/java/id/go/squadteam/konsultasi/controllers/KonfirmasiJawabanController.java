package id.go.squadteam.konsultasi.controllers;

import id.go.squadteam.konsultasi.models.entities.KonfirmasiJawaban;
import id.go.squadteam.konsultasi.models.repository.KonfirmasiJawabanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/konfirmasi-jawaban")
public class KonfirmasiJawabanController {
    @Autowired
    private KonfirmasiJawabanRepository konfirmasiJawabanRepository;

    @GetMapping
    public List<KonfirmasiJawaban> findAll() {
        return konfirmasiJawabanRepository.findAll();
    }


    @PostMapping
    public ResponseEntity< ? > save(@RequestBody KonfirmasiJawaban konfirmasi){
        if ( konfirmasi.getKonfirmasi_id() == null || konfirmasi.getStatus() == null
                || konfirmasi.getUraian() == null || konfirmasi.getKonfirmasi_id().equals("")
                || konfirmasi.getStatus().equals("")  || konfirmasi.getUraian().equals("") ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data tidak lengkap");
        } else {
            konfirmasiJawabanRepository.save(konfirmasi);
            return ResponseEntity.ok("Success");
        }
    }

    @PutMapping
    public ResponseEntity< ? > update(@RequestBody KonfirmasiJawaban konfirmasi){
        if ( konfirmasi.getKonfirmasi_id() == null || konfirmasi.getStatus() == null
                || konfirmasi.getUraian() == null || konfirmasi.getKonfirmasi_id().equals("")
                || konfirmasi.getStatus().equals("")  || konfirmasi.getUraian().equals("") ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data tidak lengkap");
        } else {
            konfirmasiJawabanRepository.save(konfirmasi);
            return ResponseEntity.ok("Success");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > detail(@PathVariable long id){
        Optional<KonfirmasiJawaban> konfirmasi = konfirmasiJawabanRepository.findById(id);
        if (konfirmasi.isPresent()){
            return ResponseEntity.ok(konfirmasi);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not valid");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity< ? > delete(@PathVariable long id){
        Optional<KonfirmasiJawaban> konfirmasi = konfirmasiJawabanRepository.findById(id);
        if (konfirmasi.isPresent()){
            konfirmasiJawabanRepository.deleteById(id);
            return ResponseEntity.ok("Delete Success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Fail");
        }
    }
}
