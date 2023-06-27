package com.electricitybill.service.impl;

import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.ClienteService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        if (clienteRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity findById(int id) {
        if (Objects.isNull(clienteRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteEntity save(ClienteEntity entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public boolean update(int id, ClienteEntity entity) throws SQLException {
        if (Objects.isNull(clienteRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return clienteRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(clienteRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return clienteRepository.delete(id);
    }
}
