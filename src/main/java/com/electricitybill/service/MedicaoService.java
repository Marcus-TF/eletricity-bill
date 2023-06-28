package com.electricitybill.service;

import com.electricitybill.dto.medicao.MedicaoMedidorResponse;
import com.electricitybill.entity.MedicaoEntity;

import java.sql.SQLException;
import java.util.List;

public interface MedicaoService {

    List<MedicaoEntity> findAll();

    MedicaoEntity findById(int id);

    MedicaoEntity save(MedicaoEntity entity);

    boolean update(int id, MedicaoEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<MedicaoMedidorResponse> findWithRouteTeam();

}
