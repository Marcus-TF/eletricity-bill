package com.electricitybill.service.impl;

import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.ClienteService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity findById(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteEntity save(ClienteEntity entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public boolean update(int id, ClienteEntity entity) throws SQLException {
        return clienteRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return clienteRepository.delete(id);
    }
}
