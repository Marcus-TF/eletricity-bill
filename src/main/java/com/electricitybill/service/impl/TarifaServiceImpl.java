package com.electricitybill.service.impl;

import com.electricitybill.entity.TarifaEntity;
import com.electricitybill.repository.TarifaRepository;
import com.electricitybill.service.TarifaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class TarifaServiceImpl implements TarifaService {

    private TarifaRepository tarifaRepository;

    @Override
    public List<TarifaEntity> findAll() {
        if (tarifaRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return tarifaRepository.findAll();
    }

    @Override
    public TarifaEntity findById(int id) {
        if (Objects.isNull(tarifaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return tarifaRepository.findById(id);
    }

    @Override
    public TarifaEntity save(TarifaEntity entity) {
        return tarifaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TarifaEntity entity) throws SQLException {
        if (Objects.isNull(tarifaRepository.findById(id))) {
            throw new NoResultException("Tax not found!");
        }
        return tarifaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(tarifaRepository.findById(id))) {
            throw new NoResultException("Tax not found!");
        }
        return tarifaRepository.delete(id);
    }
}
