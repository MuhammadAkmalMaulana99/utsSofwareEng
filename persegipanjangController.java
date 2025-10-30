import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersegiPanjangController {

    @GetMapping("/hitung")
    public String hitungBangun(
            @RequestParam(name = "p") int p, // Mengambil parameter 'p' dari URL
            @RequestParam(name = "l") int l  // Mengambil parameter 'l' dari URL
    ) {
        if (p <= 0 || l <= 0) {
            return "Nilai p dan l harus lebih besar dari 0";
        }

        if (p == l) {
            // Jika p = l, maka Bujur Sangkar
            String hasil = "Ini adalah Bujur Sangkar. ";
            int keliling = 4 * p; // Rumus keliling bujur sangkar
            int luas = p * p;     // Rumus luas bujur sangkar
            
            // Menggunakan format LaTeX seperti di soal (walau di sini hanya string)
            // Keliling = 2(p+l) -> 2(p+p) -> 4p
            // Luas = pxl -> pxp
            
            return hasil + "Keliling: " + keliling + ", Luas: " + luas;

        } else {
            // Jika p != l, maka Persegi Panjang
            String hasil = "Ini adalah Persegi Panjang. ";
            int keliling = 2 * (p + l); // Rumus Keliling = 2(p+l)
            int luas = p * l;         // Rumus Luas = pxl

            return hasil + "Keliling: " + keliling + ", Luas: " + luas;
        }
    }
}