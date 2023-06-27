package com.electricitybill.main;

import com.electricitybill.entity.PessoaEntity;
import com.electricitybill.repository.PessoaRepository;
import com.electricitybill.service.impl.PessoaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class PessoaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        PessoaRepository pessoaRepository = new PessoaRepository();
        PessoaServiceImpl pessoaService = new PessoaServiceImpl(pessoaRepository);

        // TODO test methods
        var pessoa = new PessoaEntity();

        System.out.println("1: Salvar Pessoa" +
                "\n2: Atualizar Pessoa" +
                "\n3: Deletar Pessoa" +
                "\n4: Buscar Pessoa Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                pessoa.setNome("Marcus Túlio");
                pessoa.setCpf("443.349.840-88");
                pessoa.setCnpj("98.691.270/0001-90");
                pessoa.setTipoPessoaId(1);
                System.out.println("Saved: " + pessoaService.save(pessoa));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                pessoa.setNome("Marcus Túlio Moreira Prudêncio Filho");
                pessoa.setCpf("869.392.980-10");
                pessoa.setCnpj("78.248.963/0001-04");
                pessoa.setTipoPessoaId(1);
                System.out.println("Updated: " + pessoaService.update(idUpdate, pessoa));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + pessoaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + pessoaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + pessoaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
