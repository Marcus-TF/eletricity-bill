package com.electricitybill.service.impl;

import com.electricitybill.entity.RotaEntity;
import com.electricitybill.repository.RotaRepository;
import com.electricitybill.service.RotaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RotaServiceImpl implements RotaService {

    private RotaRepository rotaRepository;

    @Override
    public List<RotaEntity> findAll() {
        if (rotaRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return rotaRepository.findAll();
    }

    @Override
    public RotaEntity findById(int id) {
        if (Objects.isNull(rotaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return rotaRepository.findById(id);
    }

    @Override
    public RotaEntity save(RotaEntity entity) {
        return rotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, RotaEntity entity) throws SQLException {
        if (Objects.isNull(rotaRepository.findById(id))) {
            throw new NoResultException("Route not found!");
        }
        return rotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(rotaRepository.findById(id))) {
            throw new NoResultException("Route not found!");
        }
        return rotaRepository.delete(id);
    }
}
