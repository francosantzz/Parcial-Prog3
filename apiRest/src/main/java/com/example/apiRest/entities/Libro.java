package com.example.apiRest.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;


import java.util.List;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends Base{
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name = "paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
     private List<Autor> autores;
}
