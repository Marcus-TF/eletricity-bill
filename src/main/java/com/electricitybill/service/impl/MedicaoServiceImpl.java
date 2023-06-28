package com.electricitybill.service.impl;

import com.electricitybill.dto.medicao.MedicaoMedidorResponse;
import com.electricitybill.entity.MedicaoEntity;
import com.electricitybill.repository.MedicaoRepository;
import com.electricitybill.service.MedicaoService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class MedicaoServiceImpl implements MedicaoService {

    private final MedicaoRepository medicaoRepository;

    @Override
    public List<MedicaoEntity> findAll() {
        if (medicaoRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return medicaoRepository.findAll();
    }

    @Override
    public MedicaoEntity findById(int id) {
        if (Objects.isNull(medicaoRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return medicaoRepository.findById(id);
    }

    @Override
    public MedicaoEntity save(MedicaoEntity entity) {
        return medicaoRepository.save(entity);
    }

    @Override
    public boolean update(int id, MedicaoEntity entity) throws SQLException {
        if (Objects.isNull(medicaoRepository.findById(id))) {
            throw new NoResultException("Measurement not found!");
        }
        return medicaoRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(medicaoRepository.findById(id))) {
            throw new NoResultException("Measurement not found!");
        }
        return medicaoRepository.delete(id);
    }

    @Override
    public List<MedicaoMedidorResponse> findWithRouteTeam() {
        if (medicaoRepository.findWithRouteTeam().isEmpty()) {
            return new ArrayList<>();
        }
        return medicaoRepository.findWithRouteTeam();
    }
}
