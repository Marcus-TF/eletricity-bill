package com.electricitybill.main;

import com.electricitybill.entity.CobrancaEntity;
import com.electricitybill.repository.CobrancaRepository;
import com.electricitybill.service.impl.CobrancaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class CobrancaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        CobrancaRepository cobrancaRepository = new CobrancaRepository();
        CobrancaServiceImpl cobrancaService = new CobrancaServiceImpl(cobrancaRepository);

        // TODO test methods
        var cobranca = new CobrancaEntity();

        System.out.println("1: Salvar cobranca" +
                "\n2: Atualizar cobranca" +
                "\n3: Deletar cobranca" +
                "\n4: Buscar cobranca Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(2);
                System.out.println("Saved: " + cobrancaService.save(cobranca));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().plusMonths(1).getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(2);
                System.out.println("Updated: " + cobrancaService.update(idUpdate, cobranca));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + cobrancaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + cobrancaService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + cobrancaService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
