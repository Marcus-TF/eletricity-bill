package com.electricitybill.main;

import com.electricitybill.entity.MedidorEntity;
import com.electricitybill.repository.MedidorRepository;
import com.electricitybill.service.impl.MedidorServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class MedidorController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        MedidorRepository repository = new MedidorRepository();
        MedidorServiceImpl medidorService = new MedidorServiceImpl(repository);

        // TODO test methods
        var medidor = new MedidorEntity();

        System.out.println("1: Salvar medidor" +
                "\n2: Atualizar medidor" +
                "\n3: Deletar medidor" +
                "\n4: Buscar medidor Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                medidor.setDescricao("inválida");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Saved: " + medidorService.save(medidor));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                if (Objects.isNull(medidorService.findById(idUpdate))) {
                    throw new NoResultException("Measurer not found!");
                }
                medidor.setDescricao("válida");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Updated: " + medidorService.update(idUpdate, medidor));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                if (Objects.isNull(medidorService.findById(idDelete))) {
                    throw new NoResultException("Measurer not found!");
                }
                System.out.println("Deleted: " + medidorService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                if (Objects.isNull(medidorService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + medidorService.findById(idSearch));
                break;
            case 5:
                if (medidorService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + medidorService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
