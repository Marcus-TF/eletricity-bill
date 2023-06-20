package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoFaseEntity;
import com.electricitybill.repository.TipoFaseRepository;
import com.electricitybill.service.TipoFaseService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TipoFaseServiceImpl implements TipoFaseService {

    private final TipoFaseRepository tipoFaseRepository;

    @Override
    public List<TipoFaseEntity> findAll() {
        return tipoFaseRepository.findAll();
    }

    @Override
    public TipoFaseEntity findById(int id) {
        return tipoFaseRepository.findById(id);
    }

    @Override
    public TipoFaseEntity save(TipoFaseEntity entity) {
        return tipoFaseRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoFaseEntity entity) throws SQLException {
        return tipoFaseRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tipoFaseRepository.delete(id);
    }
}
