package com.electricitybill.service.impl;

import com.electricitybill.dto.conta.ContaLuzResponse;
import com.electricitybill.entity.ContaLuzEntity;
import com.electricitybill.repository.ContaLuzRepository;
import com.electricitybill.service.ContaLuzService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ContaLuzServiceImpl implements ContaLuzService {

    private final ContaLuzRepository contaLuzRepository;

    @Override
    public List<ContaLuzEntity> findAll() {
        return contaLuzRepository.findAll();
    }

    @Override
    public ContaLuzResponse findById(int id) {
        return contaLuzRepository.findById(id);
    }

    @Override
    public ContaLuzEntity save(ContaLuzEntity entity) {
        return contaLuzRepository.save(entity);
    }

    @Override
    public boolean update(int id, ContaLuzEntity entity) throws SQLException {
        return contaLuzRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return contaLuzRepository.delete(id);
    }
}
