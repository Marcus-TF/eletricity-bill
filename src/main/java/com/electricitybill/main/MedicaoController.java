package com.electricitybill.main;

import com.electricitybill.entity.MedicaoEntity;
import com.electricitybill.repository.MedicaoRepository;
import com.electricitybill.service.impl.MedicaoServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class MedicaoController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        MedicaoRepository medicaoRepository = new MedicaoRepository();
        MedicaoServiceImpl medicaoService = new MedicaoServiceImpl(medicaoRepository);
        // TODO test methods
        var medicao = new MedicaoEntity();

        System.out.println("1: Salvar medicao" +
                "\n2: Atualizar medicao" +
                "\n3: Deletar medicao" +
                "\n4: Buscar medicao Por Id" +
                "\n5: Buscar Todos" +
                "\n6: Buscar Medições que contém medidor");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("152,2 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Saved: " + medicaoService.save(medicao));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("187,1 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Updated: " + medicaoService.update(idUpdate, medicao));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + medicaoService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + medicaoService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + medicaoService.findAll());
            case 6 -> System.out.println("Search: " + medicaoService.findWithRouteTeam());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
