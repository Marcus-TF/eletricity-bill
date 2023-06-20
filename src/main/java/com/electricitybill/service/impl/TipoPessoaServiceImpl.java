package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoPessoaEntity;
import com.electricitybill.repository.TipoPessoaRepository;
import com.electricitybill.service.TipoPessoaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TipoPessoaServiceImpl implements TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    @Override
    public List<TipoPessoaEntity> findAll() {
        return tipoPessoaRepository.findAll();
    }

    @Override
    public TipoPessoaEntity findById(int id) {
        return tipoPessoaRepository.findById(id);
    }

    @Override
    public TipoPessoaEntity save(TipoPessoaEntity entity) {
        return tipoPessoaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoPessoaEntity entity) throws SQLException {
        return tipoPessoaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tipoPessoaRepository.delete(id);
    }
}
