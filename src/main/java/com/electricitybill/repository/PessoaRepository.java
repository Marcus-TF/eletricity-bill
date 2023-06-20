package com.electricitybill.repository;

import com.electricitybill.entity.PessoaEntity;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO pessoa (nome, cpf, cnpj, tipo_pessoa_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, nome, cpf, cnpj, tipo_pessoa_id FROM pessoa WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM pessoa;";
    private static final String DELETE = "DELETE FROM pessoa WHERE id = ?;";
    private static final String UPDATE = "UPDATE pessoa SET nome = ?, cpf = ? , cnpj = ?, tipo_pessoa_id = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM pessoa;";

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

    public PessoaEntity save(PessoaEntity entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.setString(2, entity.getCpf());
            preparedStatement.setString(3, entity.getCnpj());
            preparedStatement.setInt(4, entity.getTipoPessoaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public PessoaEntity findById(int id) {
        PessoaEntity pessoaEntity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int tipoPessoaId = rs.getInt("tipo_pessoa_id");
                pessoaEntity = new PessoaEntity(id, nome, cpf, cnpj, tipoPessoaId);
                return pessoaEntity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<PessoaEntity> findAll() {
        List<PessoaEntity> pessoaEntityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int tipoPessoaId = rs.getInt("tipo_pessoa_id");
                pessoaEntityList.add(new PessoaEntity(id, nome, cpf, cnpj, tipoPessoaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pessoaEntityList;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, PessoaEntity entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getCpf());
            statement.setString(3, entity.getCnpj());
            statement.setInt(4, entity.getTipoPessoaId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
