package wcone.co.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcone.co.Entity.Estudiante;
import wcone.co.Repository.EstudianteRepository;
import wcone.co.Services.EstudianteServices;

import java.util.List;

@Service
public class EstudianteImplements implements EstudianteServices {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listaTotalEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Integer id) {
        return estudianteRepository.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Integer id) {
        estudianteRepository.deleteById(id);
    }


}
