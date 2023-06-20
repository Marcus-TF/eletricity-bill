package com.electricitybill.service;

import com.electricitybill.entity.FuncionarioEntity;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioService {

    List<FuncionarioEntity> findAll();

    FuncionarioEntity findById(int id);

    FuncionarioEntity save(FuncionarioEntity entity);

    boolean update(int id, FuncionarioEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
