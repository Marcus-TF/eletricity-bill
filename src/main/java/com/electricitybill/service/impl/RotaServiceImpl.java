package com.electricitybill.service.impl;

import com.electricitybill.entity.RotaEntity;
import com.electricitybill.repository.RotaRepository;
import com.electricitybill.service.RotaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class RotaServiceImpl implements RotaService {

    private RotaRepository rotaRepository;

    @Override
    public List<RotaEntity> findAll() {
        return rotaRepository.findAll();
    }

    @Override
    public RotaEntity findById(int id) {
        return rotaRepository.findById(id);
    }

    @Override
    public RotaEntity save(RotaEntity entity) {
        return rotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, RotaEntity entity) throws SQLException {
        return rotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return rotaRepository.delete(id);
    }
}
