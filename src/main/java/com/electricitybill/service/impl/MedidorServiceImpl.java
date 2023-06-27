package com.electricitybill.service.impl;

import com.electricitybill.entity.MedidorEntity;
import com.electricitybill.repository.MedidorRepository;
import com.electricitybill.service.MedidorService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class MedidorServiceImpl implements MedidorService {

    private final MedidorRepository medidorRepository;

    @Override
    public List<MedidorEntity> findAll() {
        if (medidorRepository.findAll().isEmpty()) {
            throw new NoResultException("Search not found!");
        }
        return medidorRepository.findAll();
    }

    @Override
    public MedidorEntity findById(int id) {
        if (Objects.isNull(medidorRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return medidorRepository.findById(id);
    }

    @Override
    public MedidorEntity save(MedidorEntity entity) {
        return medidorRepository.save(entity);
    }

    @Override
    public boolean update(int id, MedidorEntity entity) throws SQLException {
        if (Objects.isNull(medidorRepository.findById(id))) {
            throw new NoResultException("Measurer not found!");
        }
        return medidorRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(medidorRepository.findById(id))) {
            throw new NoResultException("Measurer not found!");
        }
        return medidorRepository.delete(id);
    }
}
