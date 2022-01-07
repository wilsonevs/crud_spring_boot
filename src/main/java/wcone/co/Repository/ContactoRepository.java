package wcone.co.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcone.co.Entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository <Contacto, Integer> {


}
