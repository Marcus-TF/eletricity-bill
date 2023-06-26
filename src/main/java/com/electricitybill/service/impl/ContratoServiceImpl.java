package com.electricitybill.service.impl;

import com.electricitybill.dto.contrato.ContratoClienteResponse;
import com.electricitybill.entity.ContratoEntity;
import com.electricitybill.repository.ContratoRepository;
import com.electricitybill.service.ContratoService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository contratoRepository;

    @Override
    public List<ContratoEntity> findAll() {
        return contratoRepository.findAll();
    }

    @Override
    public ContratoEntity findById(int id) {
        return contratoRepository.findById(id);
    }

    @Override
    public ContratoEntity save(ContratoEntity entity) {
        return contratoRepository.save(entity);
    }

    @Override
    public boolean update(int id, ContratoEntity entity) throws SQLException {
        return contratoRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return contratoRepository.delete(id);
    }

    @Override
    public List<ContratoClienteResponse> findContractWithCliente() {
        return contratoRepository.findContractWithCliente();
    }
}
