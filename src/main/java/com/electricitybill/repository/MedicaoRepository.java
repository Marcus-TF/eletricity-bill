package com.electricitybill.repository;

import com.electricitybill.dto.medicao.MedicaoMedidorResponse;
import com.electricitybill.entity.MedicaoEntity;
import com.electricitybill.service.impl.ClienteServiceImpl;
import com.electricitybill.service.impl.TimeRotaServiceImpl;
import com.electricitybill.util.ConectDataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO medicao (mes, ano, data_medicao, consumo, medidor_id, time_rota_id) VALUES(?, ?, ?, ?, ?, ?);";

    private static final String FIND_BY_ID = "SELECT id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id FROM medicao WHERE id = ?;";

    private static final String FIND_ALL = "SELECT * FROM medicao;";

    private static final String DELETE = "DELETE FROM medicao WHERE id = ?;";

    private static final String UPDATE = "UPDATE medicao SET mes = ?, ano = ?, data_medicao = ?, consumo = ?, medidor_id = ?, time_rota_id = ? WHERE id = ?;";

    private static final String TOTAL = "SELECT count(1) FROM medicao;";

    private static final String FIND_MEASUREMENT_WITH_TEAM_ROUTE = "select * from medicao inner join medidor on medicao.medidor_id = medidor.id;";

    TimeRotaRepository timeRotaRepository = new TimeRotaRepository();
    TimeRotaServiceImpl timeRotaService = new TimeRotaServiceImpl(timeRotaRepository);

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public MedicaoEntity save(MedicaoEntity entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getMes());
            preparedStatement.setString(2, entity.getAno());
            preparedStatement.setDate(3, entity.getDataMedicao());
            preparedStatement.setString(4, entity.getConsumo());
            preparedStatement.setInt(5, entity.getMedidorId());
            preparedStatement.setInt(6, entity.getTimeRotaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public MedicaoEntity findById(int id) {
        MedicaoEntity entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Date data_medicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                int time_rota_id = rs.getInt("time_rota_id");
                entity = new MedicaoEntity(id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<MedicaoEntity> findAll() {
        List<MedicaoEntity> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Date data_medicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                int time_rota_id = rs.getInt("time_rota_id");
                entityList.add(new MedicaoEntity(id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entityList;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, MedicaoEntity entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getMes());
            statement.setString(2, entity.getAno());
            statement.setDate(3, entity.getDataMedicao());
            statement.setString(4, entity.getConsumo());
            statement.setInt(5, entity.getMedidorId());
            statement.setInt(6, entity.getTimeRotaId());
            statement.setInt(7, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MedicaoMedidorResponse> findWithRouteTeam() {
        List<MedicaoMedidorResponse> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_MEASUREMENT_WITH_TEAM_ROUTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Date data_medicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                int time_rota_id = rs.getInt("time_rota_id");
                var timeRota = timeRotaService.findById(time_rota_id);
                entityList.add(new MedicaoMedidorResponse(id, mes, ano, data_medicao, consumo, medidor_id, timeRota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entityList;
    }
}
