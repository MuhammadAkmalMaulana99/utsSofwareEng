import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Menandakan ini adalah tabel database
public class Produk {

    @Id // Menandakan ini adalah Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;
    private String nama;
    private double harga;

    // Diperlukan constructor kosong untuk JPA
    public Produk() {}

    // Getters and Setters (bisa di-generate otomatis oleh IDE)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
}