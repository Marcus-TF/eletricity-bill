package com.electricitybill.service.impl;

import com.electricitybill.entity.TimeRotaEntity;
import com.electricitybill.repository.TimeRotaRepository;
import com.electricitybill.service.TimeRotaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class TimeRotaServiceImpl implements TimeRotaService {

    private final TimeRotaRepository timeRotaRepository;

    @Override
    public List<TimeRotaEntity> findAll() {
        if (timeRotaRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return timeRotaRepository.findAll();
    }

    @Override
    public TimeRotaEntity findById(int id) {
        if (Objects.isNull(timeRotaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return timeRotaRepository.findById(id);
    }

    @Override
    public TimeRotaEntity save(TimeRotaEntity entity) {
        return timeRotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TimeRotaEntity entity) throws SQLException {
        if (Objects.isNull(timeRotaRepository.findById(id))) {
            throw new NoResultException("Team route not found!");
        }
        return timeRotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(timeRotaRepository.findById(id))) {
            throw new NoResultException("Team route not found!");
        }
        return timeRotaRepository.delete(id);
    }
}
