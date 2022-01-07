package wcone.co.Services;

import wcone.co.Entity.Contacto;
import java.util.List;

public interface ContactoServices {

    public List<Contacto> listaTotalContactos();
    public Contacto buscarContactoPorId(Integer id);
    public Contacto guardarContacto(Contacto contacto);
    public Contacto actualizarContacto(Contacto contacto);
    public void eliminarContacto(Contacto contacto);

}
