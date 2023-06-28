package com.electricitybill.service;

import com.electricitybill.dto.conta.ContaLuzResponse;
import com.electricitybill.entity.ContaLuzEntity;

import java.sql.SQLException;
import java.util.List;

public interface ContaLuzService {

    List<ContaLuzEntity> findAll();

    ContaLuzResponse findById(int id);

    ContaLuzEntity save(ContaLuzEntity entity);

    boolean update(int id, ContaLuzEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
