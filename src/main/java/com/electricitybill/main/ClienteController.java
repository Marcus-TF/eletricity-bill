package com.electricitybill.main;

import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.impl.ClienteServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class ClienteController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository);

        // TODO test methods
        var cliente = new ClienteEntity();

        System.out.println("1: Salvar Cliente" +
                "\n2: Atualizar Cliente" +
                "\n3: Deletar Cliente" +
                "\n4: Buscar Cliente Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                cliente.setNumDocumento("0123.4567");
                cliente.setNumCliente("0001");
                cliente.setPessoaId(4);
                System.out.println("Saved: " + clienteService.save(cliente));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                cliente.setNumDocumento("4567.0123");
                cliente.setNumCliente("0002");
                cliente.setPessoaId(4);
                System.out.println("Updated: " + clienteService.update(idUpdate, cliente));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + clienteService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + clienteService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + clienteService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
