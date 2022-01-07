package wcone.co.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wcone.co.Entity.Contacto;
import wcone.co.Services.ContactoServices;
import wcone.co.utilidades.Constantes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoServices contactoServices;

    private static final String URLBASE = "/contacto";

    @GetMapping({"/", ""})
    public String obtenerListaContacto(Model model) {
        model.addAttribute("titulo", Constantes.TITULOS_CONTACTOS.titulo_contacto);
        model.addAttribute("contactos", contactoServices.listaTotalContactos());
        return "paginaContactos/contactos";
    }

    @GetMapping("/nuevoContacto")
    public String mostrarContactoNuevo(Model model) {
        Contacto contacto = new Contacto();
        model.addAttribute("tituloNuevo", Constantes.TITULOS_CONTACTOS.titulo_nuevo_conctactos);
        model.addAttribute("contactoNuevo", contacto);
        return "paginaContactos/formularioContactoNuevo";
    }


    @GetMapping("/editar/{id}")
    public String obtenerListaContactoPorId(@PathVariable Integer id, Model model) {
        Contacto contactos = contactoServices.buscarContactoPorId(id);
        model.addAttribute("tituloEditar", Constantes.TITULOS_CONTACTOS.titulo_editar_contacto);
        model.addAttribute("contactoEditar", contactos);
        return "paginaContactos/formularioContactoEditar";
    }

    @PostMapping("/")
    public String crearContacto(@Validated Contacto contacto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);
            return "redirect: formularioContactoNuevo";
        }
        contactoServices.guardarContacto(contacto);
        redirectAttributes.addFlashAttribute("mensaje", Constantes.MENSAJES_ALERTAS.guardar_contacto_exitosamente);
        return "redirect:" + URLBASE;
    }

    @PostMapping("/{id}")
    public String actualizarContacto(@PathVariable Integer id, @Validated Contacto contacto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("estudiante", contacto);
            return "paginaEstudiantes/formularioEstudianteEditar";
        }
        attributes.addFlashAttribute("mensajeActualizar", Constantes.MENSAJES_ALERTAS.actualizar_contactos_exitosamente);
        Contacto actualizarContacto = contactoServices.buscarContactoPorId(id);
        actualizarContacto.setId(id);
        actualizarContacto.setNombre(contacto.getNombre());
        actualizarContacto.setApellido(contacto.getApellido());
        actualizarContacto.setIndicativo(contacto.getIndicativo());
        actualizarContacto.setCelular(contacto.getCelular());
        actualizarContacto.setCorreo(contacto.getCorreo());
        actualizarContacto.setFecha_nacimiento(contacto.getFecha_nacimiento());
        contactoServices.actualizarContacto(actualizarContacto);
        return "redirect:" + URLBASE;
    }

//    @PostMapping("/{id}")
//    public String eliminarContacto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
//        Contacto contacto = contactoServices.buscarContactoPorId(id);
//        contactoServices.eliminarContacto(contacto);
//        redirectAttributes.addFlashAttribute("mensajeEliminado", "El contacto ah sido eliminado de forma satisfactoria.");
//        return "redirect:" + URLBASE;
//    }

    @GetMapping("/{id}")
    public String eliminarEstudiante(@PathVariable Integer id) {
        Contacto contacto = contactoServices.buscarContactoPorId(id);
        contactoServices.eliminarContacto(contacto);
        return "redirect:" + URLBASE;
    }

}