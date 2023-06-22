package com.electricitybill.service.impl;

import com.electricitybill.entity.MedicaoEntity;
import com.electricitybill.repository.MedicaoRepository;
import com.electricitybill.service.MedicaoService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class MedicaoServiceImpl implements MedicaoService {

    private final MedicaoRepository medicaoRepository;

    @Override
    public List<MedicaoEntity> findAll() {
        return medicaoRepository.findAll();
    }

    @Override
    public MedicaoEntity findById(int id) {
        return medicaoRepository.findById(id);
    }

    @Override
    public MedicaoEntity save(MedicaoEntity entity) {
        return medicaoRepository.save(entity);
    }

    @Override
    public boolean update(int id, MedicaoEntity entity) throws SQLException {
        return medicaoRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return medicaoRepository.delete(id);
    }
}
