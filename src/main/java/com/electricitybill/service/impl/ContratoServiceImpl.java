package com.electricitybill.service.impl;

import com.electricitybill.dto.contrato.ContratoClienteResponse;
import com.electricitybill.entity.ContratoEntity;
import com.electricitybill.repository.ContratoRepository;
import com.electricitybill.service.ContratoService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository contratoRepository;

    @Override
    public List<ContratoEntity> findAll() {
        if (contratoRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return contratoRepository.findAll();
    }

    @Override
    public ContratoEntity findById(int id) {
        if (Objects.isNull(contratoRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return contratoRepository.findById(id);
    }

    @Override
    public ContratoEntity save(ContratoEntity entity) {
        return contratoRepository.save(entity);
    }

    @Override
    public boolean update(int id, ContratoEntity entity) throws SQLException {
        if (Objects.isNull(contratoRepository.findById(id))) {
            throw new NoResultException("Contract not found!");
        }
        return contratoRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(contratoRepository.findById(id))) {
            throw new NoResultException("Contract not found!");
        }
        return contratoRepository.delete(id);
    }

    @Override
    public List<ContratoClienteResponse> findContractWithCliente() {
        if (contratoRepository.findContractWithCliente().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return contratoRepository.findContractWithCliente();
    }
}
