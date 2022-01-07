package wcone.co.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import wcone.co.utilidades.Constantes;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contacto")
public class Contacto {

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
    @Column(name = "indicativo", length = 5)
    private String indicativo;

    @NotNull(message = Constantes.ALERTAS.nulo)
    @Column(name = "celular", length = 10)
    private String celular;

    @Email
    @NotNull(message = Constantes.ALERTAS.nulo)
    @Column(name = "correo", length = 100)
    private String correo;

    @Past
    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nacimiento;

    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fecha_registro;


    public Contacto(String nombre, String indicativo, String celular, String correo, LocalDate fecha_nacimiento, LocalDateTime fecha_registro) {
        this.nombre = nombre;
        this.indicativo = indicativo;
        this.celular = celular;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_registro = fecha_registro;
    }

    @PrePersist
    public void asignarFechaRegistro(){
        fecha_registro = LocalDateTime.now();
    }


}
