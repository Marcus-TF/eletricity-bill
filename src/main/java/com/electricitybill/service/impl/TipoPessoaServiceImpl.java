package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoPessoaEntity;
import com.electricitybill.repository.TipoPessoaRepository;
import com.electricitybill.service.TipoPessoaService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class TipoPessoaServiceImpl implements TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    @Override
    public List<TipoPessoaEntity> findAll() {
        if (tipoPessoaRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return tipoPessoaRepository.findAll();
    }

    @Override
    public TipoPessoaEntity findById(int id) {
        if (Objects.isNull(tipoPessoaRepository.findById(id))) {
            throw new NoResultException("Type person type not found!");
        }
        return tipoPessoaRepository.findById(id);
    }

    @Override
    public TipoPessoaEntity save(TipoPessoaEntity entity) {
        return tipoPessoaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoPessoaEntity entity) throws SQLException {
        if (Objects.isNull(tipoPessoaRepository.findById(id))) {
            throw new NoResultException("Type person type not found!");
        }
        return tipoPessoaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(tipoPessoaRepository.findById(id))) {
            throw new NoResultException("Type person type not found!");
        }
        return tipoPessoaRepository.delete(id);
    }
}
