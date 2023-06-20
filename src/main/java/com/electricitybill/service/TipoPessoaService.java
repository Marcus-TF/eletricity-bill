package com.electricitybill.service;

import com.electricitybill.entity.TipoPessoaEntity;

import java.sql.SQLException;
import java.util.List;

public interface TipoPessoaService {

    List<TipoPessoaEntity> findAll();

    TipoPessoaEntity findById(int id);

    TipoPessoaEntity save(TipoPessoaEntity entity);

    boolean update(int id, TipoPessoaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
