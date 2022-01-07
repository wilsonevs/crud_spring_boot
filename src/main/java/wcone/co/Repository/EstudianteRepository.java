package wcone.co.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcone.co.Entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository <Estudiante, Integer> {

}
