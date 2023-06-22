package com.electricitybill.main;

import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.entity.TimeRotaEntity;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.repository.TimeRotaRepository;
import com.electricitybill.service.impl.ClienteServiceImpl;
import com.electricitybill.service.impl.TimeRotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TimeRotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        TimeRotaRepository timeRotaRepository = new TimeRotaRepository();
        TimeRotaServiceImpl timeRotaService = new TimeRotaServiceImpl(timeRotaRepository);

        // TODO test methods
        var timeRota = new TimeRotaEntity();

        System.out.println("1: Salvar timeRota" +
                "\n2: Atualizar timeRota" +
                "\n3: Deletar timeRota" +
                "\n4: Buscar timeRota Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Saved: " + timeRotaService.save(timeRota));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                if (Objects.isNull(timeRotaService.findById(idUpdate))) {
                    throw new NoResultException("Team route not found!");
                }
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Updated: " + timeRotaService.update(idUpdate, timeRota));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                if (Objects.isNull(timeRotaService.findById(idDelete))) {
                    throw new NoResultException("Team route not found!");
                }
                System.out.println("Deleted: " + timeRotaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                if (Objects.isNull(timeRotaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + timeRotaService.findById(idSearch));
                break;
            case 5:
                if (timeRotaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + timeRotaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
