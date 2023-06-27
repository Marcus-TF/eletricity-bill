package com.electricitybill.service.impl;

import com.electricitybill.entity.FuncionarioEntity;
import com.electricitybill.repository.FuncionarioRepository;
import com.electricitybill.service.FuncionarioService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioEntity> findAll() {
        if (funcionarioRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioEntity findById(int id) {
        if (Objects.isNull(funcionarioRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return funcionarioRepository.findById(id);
    }

    @Override
    public FuncionarioEntity save(FuncionarioEntity entity) {
        return funcionarioRepository.save(entity);
    }

    @Override
    public boolean update(int id, FuncionarioEntity entity) throws SQLException {
        if (Objects.isNull(funcionarioRepository.findById(id))) {
            throw new NoResultException("Employee not found!");
        }
        return funcionarioRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(funcionarioRepository.findById(id))) {
            throw new NoResultException("Employee not found!");
        }
        return funcionarioRepository.delete(id);
    }
}
