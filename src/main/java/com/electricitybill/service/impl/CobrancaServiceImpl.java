package com.electricitybill.service.impl;

import com.electricitybill.entity.CobrancaEntity;
import com.electricitybill.repository.CobrancaRepository;
import com.electricitybill.service.CobrancaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class CobrancaServiceImpl implements CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    @Override
    public List<CobrancaEntity> findAll() {
        if (cobrancaRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return cobrancaRepository.findAll();
    }

    @Override
    public CobrancaEntity findById(int id) {
        if (Objects.isNull(cobrancaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return cobrancaRepository.findById(id);
    }

    @Override
    public CobrancaEntity save(CobrancaEntity entity) {
        return cobrancaRepository.save(entity);
    }

    @Override
    public boolean update(int id, CobrancaEntity entity) throws SQLException {
        if (Objects.isNull(cobrancaRepository.findById(id))) {
            throw new NoResultException("Billing not found!");
        }
        return cobrancaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(cobrancaRepository.findById(id))) {
            throw new NoResultException("Billing not found!");
        }
        return cobrancaRepository.delete(id);
    }
}
