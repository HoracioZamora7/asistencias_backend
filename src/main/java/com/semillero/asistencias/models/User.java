package com.semillero.asistencias.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "contrasenia")
    @Basic(fetch = FetchType.LAZY)
    private String password;

    /* @Column(nullable = false)
    private boolean enabled = true; */

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private UsuarioEstadoEntity estado;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntity empleado;

}
