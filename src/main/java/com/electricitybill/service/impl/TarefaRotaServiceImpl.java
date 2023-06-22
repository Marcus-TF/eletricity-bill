package com.electricitybill.service.impl;

import com.electricitybill.entity.TarefaRotaEntity;
import com.electricitybill.repository.TarefaRotaRepository;
import com.electricitybill.service.TarefaRotaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TarefaRotaServiceImpl implements TarefaRotaService {

    private final TarefaRotaRepository tarefaRotaRepository;

    @Override
    public List<TarefaRotaEntity> findAll() {
        return tarefaRotaRepository.findAll();
    }

    @Override
    public TarefaRotaEntity findById(int id) {
        return tarefaRotaRepository.findById(id);
    }

    @Override
    public TarefaRotaEntity save(TarefaRotaEntity entity) {
        return tarefaRotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TarefaRotaEntity entity) throws SQLException {
        return tarefaRotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tarefaRotaRepository.delete(id);
    }
}
