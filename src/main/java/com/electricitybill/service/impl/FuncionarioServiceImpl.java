package com.electricitybill.service.impl;

import com.electricitybill.entity.FuncionarioEntity;
import com.electricitybill.repository.FuncionarioRepository;
import com.electricitybill.service.FuncionarioService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioEntity> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioEntity findById(int id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public FuncionarioEntity save(FuncionarioEntity entity) {
        return funcionarioRepository.save(entity);
    }

    @Override
    public boolean update(int id, FuncionarioEntity entity) throws SQLException {
        return funcionarioRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return funcionarioRepository.delete(id);
    }
}
