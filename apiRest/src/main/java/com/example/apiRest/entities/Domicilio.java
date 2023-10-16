package com.example.apiRest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Domicilio extends Base {
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
