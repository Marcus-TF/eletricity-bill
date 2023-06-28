package com.electricitybill.main;

import com.electricitybill.entity.TarefaRotaEntity;
import com.electricitybill.repository.TarefaRotaRepository;
import com.electricitybill.service.impl.TarefaRotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class TarefaRotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        TarefaRotaRepository tarefaRotaRepository = new TarefaRotaRepository();
        TarefaRotaServiceImpl tarefaRotaService = new TarefaRotaServiceImpl(tarefaRotaRepository);

        // TODO test methods
        var tarefaRota = new TarefaRotaEntity();

        System.out.println("1: Salvar tarefaRota" +
                "\n2: Atualizar tarefaRota" +
                "\n3: Deletar tarefaRota" +
                "\n4: Buscar tarefaRota Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                tarefaRota.setObservacao("Tarefa Incompleta");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(7)));
                tarefaRota.setRotaId(1);
                System.out.println("Saved: " + tarefaRotaService.save(tarefaRota));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tarefaRota.setObservacao("Tarefa Finalizada");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(7)));
                tarefaRota.setRotaId(1);
                System.out.println("Updated: " + tarefaRotaService.update(idUpdate, tarefaRota));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tarefaRotaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tarefaRotaService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + tarefaRotaService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
