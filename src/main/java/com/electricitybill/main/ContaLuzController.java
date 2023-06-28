package com.electricitybill.main;

import com.electricitybill.entity.ContaLuzEntity;
import com.electricitybill.repository.ContaLuzRepository;
import com.electricitybill.service.impl.ContaLuzServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ContaLuzController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner ler = new Scanner(System.in);
        ContaLuzRepository contaLuzRepository = new ContaLuzRepository();
        ContaLuzServiceImpl contaLuzService = new ContaLuzServiceImpl(contaLuzRepository);

        // TODO test methods
        var contaLuz = new ContaLuzEntity();

        System.out.println("1: Salvar conta de luz" +
                "\n2: Atualizar conta de luz" +
                "\n3: Deletar conta de luz" +
                "\n4: Buscar conta de luz Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1 -> {
                contaLuz.setClienteId(1);
                contaLuz.setMedicaoId(2);
                contaLuz.setCobrancaId(1);
                contaLuz.setTarifaId(1);
                System.out.println("Saved: " + contaLuzService.save(contaLuz));
            }
            case 2 -> {
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                contaLuz.setClienteId(1);
                contaLuz.setMedicaoId(2);
                contaLuz.setCobrancaId(1);
                contaLuz.setTarifaId(1);
                System.out.println("Updated: " + contaLuzService.update(idUpdate, contaLuz));
            }
            case 3 -> {
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + contaLuzService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + contaLuzService.findById(idSearch));
            }
            case 5 -> System.out.println("Search: " + contaLuzService.findAll());
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
