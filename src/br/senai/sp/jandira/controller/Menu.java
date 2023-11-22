package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar){

            System.out.println("========== WELCOME ==========");
            System.out.println("=============================");
            System.out.println("            MENU             ");
            System.out.println("1 - Listar Funcionario       ");
            System.out.println("2- Cadastrar Funcionario     ");
            System.out.println("3- Editar Funcionario        ");
            System.out.println("4- Deletar Funcionario       ");
            System.out.println("5- Pesquisar Funcionario     ");
            System.out.println("6 Sair");
            System.out.println("=============================");

            Scanner scanner = new Scanner(System.in);

            int userOption = scanner.nextInt();
            scanner.nextLine();
            FuncionarioController funcionario = new FuncionarioController();

            switch (userOption){
                case 1:
                    funcionario.listarFuncionarios();
                    break;
                case 2:
                    Funcionario newFuncionario = new Funcionario();
                    newFuncionario.cadastrarFuncionario();

                    funcionario.cadastrarFuncionario(newFuncionario);
                    break;
                case 3:
                    System.out.println("Informe o nome que deseja atualizar: ");
                    String nomeUpdate = scanner.nextLine();
                    System.out.println("Informe o novo salário: ");
                    Double newSalario = scanner.nextDouble();
                    scanner.nextLine();
                    funcionario.editarFuncionario(nomeUpdate, newSalario);
                    break;
                case 4:
                    System.out.println("Informe o nome que deseja deletar: ");
                    String nome = scanner.nextLine();
                    funcionario.deletarFuncionario(nome);
                    break;
                case 5:
                    System.out.println("Informe o nome que deseja procurar: ");
                    nome = scanner.nextLine();
                    funcionario.consultarFuncionario(nome);
                    break;
                case 6:
                    continuar = false;
                    break;
            }
        }
    }
}
