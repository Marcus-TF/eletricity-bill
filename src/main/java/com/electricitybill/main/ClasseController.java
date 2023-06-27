package com.electricitybill.main;

import com.electricitybill.entity.ClasseEntity;
import com.electricitybill.entity.ClienteEntity;
import com.electricitybill.repository.ClasseRepository;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.impl.ClasseServiceImpl;
import com.electricitybill.service.impl.ClienteServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class ClasseController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        ClasseRepository classeRepository = new ClasseRepository();
        ClasseServiceImpl classeService = new ClasseServiceImpl(classeRepository);

        // TODO test methods
        var classe = new ClasseEntity();

        System.out.println("1: Salvar classe" +
                "\n2: Atualizar classe" +
                "\n3: Deletar classe" +
                "\n4: Buscar classe Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                classe.setDescricao("Saved Class");
                classe.setTipoFaseId(1);
                System.out.println("Saved: " + classeService.save(classe));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                classe.setDescricao("Updated Class");
                classe.setTipoFaseId(1);
                System.out.println("Updated: " + classeService.update(idUpdate, classe));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + classeService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + classeService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + classeService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
