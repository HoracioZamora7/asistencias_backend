package com.semillero.asistencias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario_roles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRols {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

 
    @ManyToOne 
    @JoinColumn(name = "id_rol")
    Role role;

    @ManyToOne 
    @JoinColumn(name = "id_usuario")
    User user;
}
