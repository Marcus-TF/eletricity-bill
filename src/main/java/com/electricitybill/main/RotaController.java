package com.electricitybill.main;

import com.electricitybill.entity.RotaEntity;
import com.electricitybill.repository.RotaRepository;
import com.electricitybill.service.impl.RotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class RotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        RotaRepository repository = new RotaRepository();
        RotaServiceImpl rotaService = new RotaServiceImpl(repository);

        // TODO test methods
        var rota = new RotaEntity();

        System.out.println("1: Salvar Rota" +
                "\n2: Atualizar Rota" +
                "\n3: Deletar Rota" +
                "\n4: Buscar Rota Por Id" +
                "\n5: Buscar Todas");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                rota.setDescricao("Maraponga");
                System.out.println("Saved: " + rotaService.save(rota));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                rota.setDescricao("Parangaba");
                System.out.println("Updated: " + rotaService.update(idUpdate, rota));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + rotaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                if (Objects.isNull(rotaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + rotaService.findById(idSearch));
                break;
            case 5:
                if (rotaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + rotaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
