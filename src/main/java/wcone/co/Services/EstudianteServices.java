package wcone.co.Services;
import wcone.co.Entity.Estudiante;

import java.util.List;

public interface EstudianteServices {

    public List<Estudiante> listaTotalEstudiantes();
    public Estudiante guardarEstudiante(Estudiante estudiante);
    public Estudiante obtenerEstudiantePorId(Integer id);
    public Estudiante actualizarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante(Integer id);

}
