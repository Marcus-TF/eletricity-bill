package com.electricitybill.service.impl;

import com.electricitybill.entity.TarifaEntity;
import com.electricitybill.repository.TarifaRepository;
import com.electricitybill.service.TarifaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TarifaServiceImpl implements TarifaService {

    private TarifaRepository tarifaRepository;

    @Override
    public List<TarifaEntity> findAll() {
        return tarifaRepository.findAll();
    }

    @Override
    public TarifaEntity findById(int id) {
        return tarifaRepository.findById(id);
    }

    @Override
    public TarifaEntity save(TarifaEntity entity) {
        return tarifaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TarifaEntity entity) throws SQLException {
        return tarifaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tarifaRepository.delete(id);
    }
}
