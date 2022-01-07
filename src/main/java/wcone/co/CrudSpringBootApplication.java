package wcone.co;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wcone.co.Repository.EstudianteRepository;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public void run(String... args) throws Exception {
//		Estudiante estudiante1 = new Estudiante("Wilson", "Valencia", "wilson_evs@hotmail.com");
//		Estudiante estudiante2 = new Estudiante("Johana", "Valencia", "johana_291@hotmail.com");
//		Estudiante estudiante3 = new Estudiante("Liz", "Alegre", "jess@hotmail.com");
//		Estudiante estudiante4 = new Estudiante("Emilio", "Vanegas", "emilio_vanegas@hotmail.com");
//		Estudiante estudiante5 = new Estudiante("Ruth", "Saldarriaga", "ruth_saldarriaga@hotmail.com");
//		Estudiante estudiante6 = new Estudiante("Lina", "Marcela", "lina_marcela@hotmail.com");
// 		Estudiante estudiante7 = new Estudiante("Camilo", "Lopez", "camilo_lopez@hotmail.com");
//		estudianteRepository.save(estudiante1);
//		estudianteRepository.save(estudiante2);
//		estudianteRepository.save(estudiante3);
// 		estudianteRepository.save(estudiante4);
//		estudianteRepository.save(estudiante5);
//		estudianteRepository.save(estudiante6);
// 		estudianteRepository.save(estudiante7);
	}

}