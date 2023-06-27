package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoFaseEntity;
import com.electricitybill.repository.TipoFaseRepository;
import com.electricitybill.service.TipoFaseService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class TipoFaseServiceImpl implements TipoFaseService {

    private final TipoFaseRepository tipoFaseRepository;

    @Override
    public List<TipoFaseEntity> findAll() {
        if (tipoFaseRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return tipoFaseRepository.findAll();
    }

    @Override
    public TipoFaseEntity findById(int id) {
        if (Objects.isNull(tipoFaseRepository.findById(id))) {
            throw new NoResultException("Phase type not found!");
        }
        return tipoFaseRepository.findById(id);
    }

    @Override
    public TipoFaseEntity save(TipoFaseEntity entity) {
        return tipoFaseRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoFaseEntity entity) throws SQLException {
        if (Objects.isNull(tipoFaseRepository.findById(id))) {
            throw new NoResultException("Phase type not found!");
        }
        return tipoFaseRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(tipoFaseRepository.findById(id))) {
            throw new NoResultException("Phase type not found!");
        }
        return tipoFaseRepository.delete(id);
    }
}
