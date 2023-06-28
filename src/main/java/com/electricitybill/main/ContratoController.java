package com.electricitybill.main;

import com.electricitybill.entity.ContratoEntity;
import com.electricitybill.repository.ContratoRepository;
import com.electricitybill.service.impl.ContratoServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ContratoController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        ContratoRepository contratoRepository = new ContratoRepository();
        ContratoServiceImpl contratoService = new ContratoServiceImpl(contratoRepository);

        // TODO test methods
        var contrato = new ContratoEntity();
        System.out.println("1: Salvar contrato" +
                "\n2: Atualizar contrato" +
                "\n3: Deletar contrato" +
                "\n4: Buscar contrato Por Id" +
                "\n5: Buscar Todos" +
                "\n6: Buscar contratos que possuem clientes");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                contrato.setDescricao("Tem Gato!");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Saved: " + contratoService.save(contrato));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                contrato.setDescricao("Gato removido!");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Updated: " + contratoService.update(idUpdate, contrato));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + contratoService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + contratoService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + contratoService.findAll());
            case 6 -> System.out.println("Search: " + contratoService.findContractWithCliente());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
