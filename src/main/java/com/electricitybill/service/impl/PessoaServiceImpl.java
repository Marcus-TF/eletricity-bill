package com.electricitybill.service.impl;

import com.electricitybill.entity.PessoaEntity;
import com.electricitybill.repository.PessoaRepository;
import com.electricitybill.service.PessoaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public List<PessoaEntity> findAll() {
        if (pessoaRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return pessoaRepository.findAll();
    }

    @Override
    public PessoaEntity findById(int id) {
        if (Objects.isNull(pessoaRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return pessoaRepository.findById(id);
    }

    @Override
    public PessoaEntity save(PessoaEntity entity) {
        return pessoaRepository.save(entity);
    }

    @Override
    public boolean update(int id, PessoaEntity entity) throws SQLException {
        if (Objects.isNull(pessoaRepository.findById(id))) {
            throw new NoResultException("Person not found!");
        }
        return pessoaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(pessoaRepository.findById(id))) {
            throw new NoResultException("Person not found!");
        }
        return pessoaRepository.delete(id);
    }
}
