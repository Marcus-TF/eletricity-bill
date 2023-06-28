package com.electricitybill.main;

import com.electricitybill.entity.PosteEntity;
import com.electricitybill.repository.PosteRepository;
import com.electricitybill.service.impl.PosteServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class PosteController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        PosteRepository repository = new PosteRepository();
        PosteServiceImpl posteService = new PosteServiceImpl(repository);

        // TODO test methods
        var poste = new PosteEntity();

        System.out.println("1: Salvar Poste" +
                "\n2: Atualizar Poste" +
                "\n3: Deletar Poste" +
                "\n4: Buscar Poste Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                poste.setLatitude("-142.4093");
                poste.setLongitude("-37.4479");
                poste.setCodigo("647326349");
                poste.setObservacao("Save");
                System.out.println("Saved: " + posteService.save(poste));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                poste.setLatitude("58.3731");
                poste.setLongitude("-86.7386");
                poste.setCodigo("647326349");
                poste.setObservacao("Update");
                System.out.println("Updated: " + posteService.update(idUpdate, poste));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + posteService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + posteService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + posteService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
