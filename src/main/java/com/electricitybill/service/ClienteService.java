package com.electricitybill.service;

import com.electricitybill.entity.ClienteEntity;

import java.sql.SQLException;
import java.util.List;

public interface ClienteService {

    List<ClienteEntity> findAll();

    ClienteEntity findById(int id);

    ClienteEntity save(ClienteEntity entity);

    boolean update(int id, ClienteEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
