package com.electricitybill.main;

import com.electricitybill.entity.TipoPessoaEntity;
import com.electricitybill.repository.TipoPessoaRepository;
import com.electricitybill.service.impl.TipoPessoaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TipoPessoaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        TipoPessoaRepository tipoPessoaRepository = new TipoPessoaRepository();
        TipoPessoaServiceImpl tipoPessoaService = new TipoPessoaServiceImpl(tipoPessoaRepository);

        // TODO test methods
        var tipoPessoa = new TipoPessoaEntity();

        System.out.println("1: Salvar Tipo Pessoa" +
                "\n2: Atualizar Tipo Pessoa" +
                "\n3: Deletar Tipo Pessoa" +
                "\n4: Buscar Tipo Pessoa Por Id " +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                tipoPessoa.setDescricao("Pessoa Física");
                System.out.println("Saved: " + tipoPessoaService.save(tipoPessoa));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tipoPessoa.setDescricao("Pessoa Juridica");
                System.out.println("Updated: " + tipoPessoaService.update(idUpdate, tipoPessoa));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tipoPessoaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tipoPessoaService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + tipoPessoaService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
