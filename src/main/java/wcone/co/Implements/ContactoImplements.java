package wcone.co.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcone.co.Entity.Contacto;
import wcone.co.Repository.ContactoRepository;
import wcone.co.Services.ContactoServices;

import java.util.List;

@Service
public class ContactoImplements implements ContactoServices {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> listaTotalContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer id) {
        return contactoRepository.findById(id).get();
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    @Override
    public Contacto actualizarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }


}
