package com.electricitybill.repository;

import com.electricitybill.dto.conta.ContaLuz;
import com.electricitybill.entity.CobrancaEntity;
import com.electricitybill.entity.ContaLuzEntity;
import com.electricitybill.service.impl.*;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaLuzRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO conta_luz (cliente_id, medicao_id, cobranca_id, tarifa_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, cliente_id, medicao_id, cobranca_id, tarifa_id FROM conta_luz WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM conta_luz;";
    private static final String DELETE = "DELETE FROM conta_luz WHERE id = ?;";
    private static final String UPDATE = "UPDATE conta_luz SET cliente_id = ?, medicao_id = ?, cobranca_id = ?, tarifa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM conta_luz;";

    ClienteRepository clienteRepository = new ClienteRepository();
    ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository);
    MedicaoRepository repository = new MedicaoRepository();
    MedicaoServiceImpl medicaoService = new MedicaoServiceImpl(repository);
    CobrancaRepository cobrancaRepository = new CobrancaRepository();
    CobrancaServiceImpl cobrancaService = new CobrancaServiceImpl(cobrancaRepository);
    TarifaRepository tarifaRepository = new TarifaRepository();
    TarifaServiceImpl tarifaService = new TarifaServiceImpl(tarifaRepository);

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

    public ContaLuzEntity save(ContaLuzEntity entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setInt(1, entity.getClienteId());
            preparedStatement.setInt(2, entity.getMedicaoId());
            preparedStatement.setInt(3, entity.getCobrancaId());
            preparedStatement.setInt(4, entity.getTarifaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ContaLuz findById(int id) {
        ContaLuz entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int cliente_id = rs.getInt("cliente_id");
                int medicao_id = rs.getInt("medicao_id");
                int cobranca_id = rs.getInt("cobranca_id");
                int tarifa_id = rs.getInt("tarifa_id");
                var cliente = clienteService.findById(cliente_id);
                var medicao = medicaoService.findById(medicao_id);
                var cobranca = cobrancaService.findById(cobranca_id);
                var tarifa = tarifaService.findById(tarifa_id);
                entity = new ContaLuz(id,cliente, medicao, cobranca, tarifa);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<ContaLuzEntity> findAll() {
        List<ContaLuzEntity> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int cliente_id = rs.getInt("cliente_id");
                int medicao_id = rs.getInt("medicao_id");
                int cobranca_id = rs.getInt("cobranca_id");
                int tarifa_id = rs.getInt("tarifa_id");
                entityList.add(new ContaLuzEntity(id,cliente_id, medicao_id, cobranca_id, tarifa_id));
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

    public boolean update(int id, ContaLuzEntity entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setInt(1, entity.getClienteId());
            statement.setInt(2, entity.getMedicaoId());
            statement.setInt(3, entity.getCobrancaId());
            statement.setInt(4, entity.getTarifaId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
