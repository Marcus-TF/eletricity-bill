package com.electricitybill.service;

import com.electricitybill.entity.PessoaEntity;

import java.sql.SQLException;
import java.util.List;

public interface PessoaService {

    List<PessoaEntity> findAll();

    PessoaEntity findById(int id);

    PessoaEntity save(PessoaEntity entity);

    boolean update(int id, PessoaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
