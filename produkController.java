import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produk") // Semua endpoint di kelas ini diawali /api/produk
public class ProdukController {

    @Autowired // Ini adalah Dependency Injection!
    private ProdukRepository produkRepository;

    // CREATE
    @PostMapping
    public Produk createProduk(@RequestBody Produk produk) {
        return produkRepository.save(produk);
    }

    // READ (All)
    @GetMapping
    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    // READ (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
        Optional<Produk> produk = produkRepository.findById(id);
        if (produk.isPresent()) {
            return ResponseEntity.ok(produk.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Produk> updateProduk(@PathVariable Long id, @RequestBody Produk detailProduk) {
        Optional<Produk> produkOptional = produkRepository.findById(id);
        if (produkOptional.isPresent()) {
            Produk produk = produkOptional.get();
            produk.setNama(detailProduk.getNama());
            produk.setHarga(detailProduk.getHarga());
            return ResponseEntity.ok(produkRepository.save(produk));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduk(@PathVariable Long id) {
        if (produkRepository.existsById(id)) {
            produkRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}