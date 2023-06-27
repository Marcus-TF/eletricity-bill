package com.electricitybill.service.impl;

import com.electricitybill.entity.TarefaRotaEntity;
import com.electricitybill.repository.TarefaRotaRepository;
import com.electricitybill.service.TarefaRotaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class TarefaRotaServiceImpl implements TarefaRotaService {

    private final TarefaRotaRepository tarefaRotaRepository;

    @Override
    public List<TarefaRotaEntity> findAll() {
        if (tarefaRotaRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return tarefaRotaRepository.findAll();
    }

    @Override
    public TarefaRotaEntity findById(int id) {
        if (Objects.isNull(tarefaRotaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return tarefaRotaRepository.findById(id);
    }

    @Override
    public TarefaRotaEntity save(TarefaRotaEntity entity) {
        return tarefaRotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TarefaRotaEntity entity) throws SQLException {
        if (Objects.isNull(tarefaRotaRepository.findById(id))) {
            throw new NoResultException("Route task not found!");
        }
        return tarefaRotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(tarefaRotaRepository.findById(id))) {
            throw new NoResultException("Route task not found!");
        }
        return tarefaRotaRepository.delete(id);
    }
}
