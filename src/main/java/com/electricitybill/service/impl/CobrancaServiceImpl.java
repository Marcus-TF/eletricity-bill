package com.electricitybill.service.impl;

import com.electricitybill.entity.CobrancaEntity;
import com.electricitybill.repository.CobrancaRepository;
import com.electricitybill.service.CobrancaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class CobrancaServiceImpl implements CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    @Override
    public List<CobrancaEntity> findAll() {
        return cobrancaRepository.findAll();
    }

    @Override
    public CobrancaEntity findById(int id) {
        return cobrancaRepository.findById(id);
    }

    @Override
    public CobrancaEntity save(CobrancaEntity entity) {
        return cobrancaRepository.save(entity);
    }

    @Override
    public boolean update(int id, CobrancaEntity entity) throws SQLException {
        return cobrancaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return cobrancaRepository.delete(id);
    }
}
