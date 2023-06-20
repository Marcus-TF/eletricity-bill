package com.electricitybill.main;

import com.electricitybill.entity.FuncionarioEntity;
import com.electricitybill.repository.FuncionarioRepository;
import com.electricitybill.service.impl.FuncionarioServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class FuncionarioController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        // TODO test methods
        var funcionario = new FuncionarioEntity();

        System.out.println("1: Salvar Funcionario" +
                "\n2: Atualizar Funcionario" +
                "\n3: Deletar Funcionario" +
                "\n4: Buscar Funcionario Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                funcionario.setCodigoFuncional("0123.4567");
                funcionario.setPessoaId(4);
                System.out.println("Saved: " + funcionarioService.save(funcionario));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                funcionario.setCodigoFuncional("4567.0123");
                funcionario.setPessoaId(4);
                System.out.println("Updated: " + funcionarioService.update(idUpdate, funcionario));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + funcionarioService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                if (Objects.isNull(funcionarioService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + funcionarioService.findById(idSearch));
                break;
            case 5:
                if (funcionarioService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + funcionarioService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
