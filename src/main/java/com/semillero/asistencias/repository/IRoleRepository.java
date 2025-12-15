package com.semillero.asistencias.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.semillero.asistencias.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    

}
