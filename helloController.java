import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Menandakan kelas ini adalah Controller untuk REST API
public class HelloController {

    @GetMapping("/hello") // Merespons permintaan GET di alamat /hello
    public String hello() {
        return "Hello WORK"; // Mengembalikan teks "Hello WORK"
    }
}