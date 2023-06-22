package com.electricitybill.main;

import com.electricitybill.entity.TarifaEntity;
import com.electricitybill.repository.TarifaRepository;
import com.electricitybill.service.impl.TarifaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class TarifaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        TarifaRepository tarifaRepository = new TarifaRepository();
        TarifaServiceImpl tarifaService = new TarifaServiceImpl(tarifaRepository);

        // TODO test methods
        var tarifa = new TarifaEntity();

        System.out.println("1: Salvar tarifa" +
                "\n2: Atualizar tarifa" +
                "\n3: Deletar tarifa" +
                "\n4: Buscar tarifa Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                tarifa.setTaxa("Bandeira Amarela");
                tarifa.setClasseId(1);
                tarifa.setLei("Não");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now()));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                tarifa.setAliquotaIcms("17%");
                System.out.println("Saved: " + tarifaService.save(tarifa));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tarifa.setTaxa("Bandeira Verde");
                tarifa.setClasseId(1);
                tarifa.setLei("Não");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now().plusDays(7)));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusDays(7).plusMonths(1)));
                tarifa.setAliquotaIcms("15%");
                System.out.println("Updated: " + tarifaService.update(idUpdate, tarifa));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tarifaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                if (Objects.isNull(tarifaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + tarifaService.findById(idSearch));
                break;
            case 5:
                if (tarifaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + tarifaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
