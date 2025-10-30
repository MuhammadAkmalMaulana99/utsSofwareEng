import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
    // Spring Data JPA otomatis menyediakan metode seperti:
    // save() -> (Create & Update)
    // findById() -> (Read)
    // findAll() -> (Read all)
    // deleteById() -> (Delete)
}