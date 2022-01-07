package wcone.co.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wcone.co.Entity.Estudiante;
import wcone.co.Services.EstudianteServices;
import wcone.co.utilidades.Constantes;

import javax.validation.Valid;

@Controller
@RequestMapping({"/estudiante/", "/estudiante", ""})
public class EstudianteController {

    @Autowired
    private EstudianteServices estudianteServices;

    private static final String URLBASE = "/estudiante/";

    @GetMapping({"/", ""})
    public String obtenerListaEstudiantes(Model model) {
        model.addAttribute("titulo", Constantes.TITULOS_ESTUDIANTE.titulo_estudiante);
        model.addAttribute("estudiantes", estudianteServices.listaTotalEstudiantes());
        return "paginaEstudiantes/estudiantes";
    }


    @GetMapping("/nuevoEstudiante")
    public String mostraEstudianteNuevoFormulario(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("titulo", Constantes.TITULOS_ESTUDIANTE.titulo_nuevo_estudiante);
        model.addAttribute("estudianteNuevo", estudiante);
        return "paginaEstudiantes/formularioEstudianteNuevo";
    }

    @GetMapping("/editar/{id}")
    public String obtenerEstudiantePorId(@PathVariable Integer id, Model model) {
        model.addAttribute("titulo", Constantes.TITULOS_ESTUDIANTE.titulo_editar_estudiante);
        model.addAttribute("estudianteEditar", estudianteServices.obtenerEstudiantePorId(id));
        return "paginaEstudiantes/formularioEstudianteEditar";
    }

    @PostMapping("/")
    public String crearEstudiante(@Validated Estudiante estudiante, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("estudiante", estudiante);
            return "paginaEstudiantes/formularioEstudianteNuevo";
        }
        redirectAttributes.addFlashAttribute("mensaje", Constantes.MENSAJES_ALERTAS.guardar_estudiante_exitosamente);
        estudianteServices.guardarEstudiante(estudiante);
        return "redirect:" + URLBASE;
    }

    @PostMapping("/{id}")
    public String actualizarEstudiante(@PathVariable Integer id, @Validated Estudiante estudiante, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("estudiante", estudiante);
            return "paginaEstudiantes/formularioEstudianteEditar";
        }
        redirectAttributes.addFlashAttribute("mensajeActualizar", Constantes.MENSAJES_ALERTAS.actualizar_estudiante_exitosamente);
        Estudiante estudianteExtistente = estudianteServices.obtenerEstudiantePorId(id);
        estudianteExtistente.setId(id);
        estudianteExtistente.setNombre(estudiante.getNombre());
        estudianteExtistente.setApellido(estudiante.getApellido());
        estudianteExtistente.setCorreo(estudiante.getCorreo());
        estudianteServices.actualizarEstudiante(estudianteExtistente);
        return "redirect:" + URLBASE;
    }


    @GetMapping("/{id}")
    public String eliminarEstudiante(@PathVariable Integer id) {
        estudianteServices.eliminarEstudiante(id);
        return "redirect:" + URLBASE;
    }

}














