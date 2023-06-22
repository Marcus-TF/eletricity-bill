package com.electricitybill.service;

import com.electricitybill.entity.TarefaRotaEntity;

import java.sql.SQLException;
import java.util.List;

public interface TarefaRotaService {

    List<TarefaRotaEntity> findAll();

    TarefaRotaEntity findById(int id);

    TarefaRotaEntity save(TarefaRotaEntity entity);

    boolean update(int id, TarefaRotaEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
