package wcone.co.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import wcone.co.utilidades.Constantes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = Constantes.ALERTAS.nulo)
    @Column(name = "nombre", length = 75)
    private String nombre;

    @NotNull(message = Constantes.ALERTAS.nulo)
    @Column(name = "apellido", length = 75)
    private String apellido;


    @NotNull(message = Constantes.ALERTAS.nulo)
    @Email
    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fecha_registro;


    public Estudiante(String nombre, String apellido, String correo,  LocalDateTime fecha_registro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
    }

    @PrePersist
    public void asignarFechaRegistro(){
        fecha_registro = LocalDateTime.now();
    }

}
