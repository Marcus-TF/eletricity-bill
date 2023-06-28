package com.electricitybill.main;

import com.electricitybill.entity.TipoFaseEntity;
import com.electricitybill.repository.TipoFaseRepository;
import com.electricitybill.service.impl.TipoFaseServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TipoFaseController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        TipoFaseRepository repository = new TipoFaseRepository();
        TipoFaseServiceImpl tipoFaseService = new TipoFaseServiceImpl(repository);

        // TODO test methods
        var tipoFase = new TipoFaseEntity();

        System.out.println("1: Salvar Tipo Fase" +
                "\n2: Atualizar Tipo Fase" +
                "\n3: Deletar Tipo Fase" +
                "\n4: Buscar Tipo Fase Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                tipoFase.setDescricao("Teste");
                System.out.println("Saved: " + tipoFaseService.save(tipoFase));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tipoFase.setDescricao("Teste Atualizado");
                System.out.println("Updated: " + tipoFaseService.update(idUpdate, tipoFase));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tipoFaseService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tipoFaseService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + tipoFaseService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
