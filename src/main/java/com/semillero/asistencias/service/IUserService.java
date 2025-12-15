package com.semillero.asistencias.service;

import com.semillero.asistencias.models.User;

public interface IUserService {

    User getByUserName(String username);

}
