package application;
import entities.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> Alunos = new ArrayList<Aluno>();

        int option = 42;

        while(option != 0) {
            System.out.println("--------------------------------------------------------");
            System.out.println("\t\t MENU");
            System.out.println("--------------------------------------------------------");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("0 - Sair");


            if(scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0) {
                    return;
                }
                else if(option == 1) {
                    cadastrarAluno(scanner, Alunos);
                }
                else if(option == 2) {
                    listarAlunos(Alunos);
                }
                else {
                    System.out.println("Valor inválido, por favor informe um novo valor...");
                    option = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void cadastrarAluno(Scanner scanner, ArrayList<Aluno> alunos) {
        int matricula = 0;
        String nome = null;
        double[] notas = new double[3];
        char[] assiduidade = new char[60];


        System.out.println("Informe a matrícula do Aluno: ");
        if(scanner.hasNextInt()) {
            matricula = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Informe o Nome do Aluno: ");
        if(scanner.hasNextLine()) {
            nome = scanner.nextLine();
        }

        System.out.println("Informe as três notas do Aluno: ");
        for (int i = 0; i < notas.length; i++){
            System.out.printf("Informe a nota da prova %d\n", i + 1);
            if(scanner.hasNextDouble()) {
                notas[i] = scanner.nextDouble();
                scanner.nextLine();
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
                return;
            }
        }


        System.out.println("Informe a Assiduidade do Aluno - [0]falta   [1]presente: ");
        for (int i = 0; i < assiduidade.length; i++){
            if(scanner.hasNextInt()) {
                System.out.printf("O Aluno estava Presente na Aula %d - [0]falta   [1]presente\n", i + 1);
                assiduidade[i] = scanner.next().charAt(0);
                scanner.nextLine();
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
                return;
            }
        }

        Aluno aluno  = new Aluno(matricula, nome, notas, assiduidade);

        alunos.add(aluno);

        System.out.println("\nFuncionário cadastrado com sucesso: ");
        System.out.println("--------------------------------------------------------");
        System.out.println(aluno);
        System.out.println("--------------------------------------------------------");

        System.out.println("\nGostaria de cadastrar outro Aluno?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int cadastrar = 42;
        if(scanner.hasNextInt()) {
            cadastrar = scanner.nextInt();
            scanner.nextLine();
        }
        else {
            System.out.println("\n\tValor inválido...");
            System.out.println("\tRetornando para o Menu Principal...\n");
            scanner.nextLine();
            return;
        }

        if(cadastrar == 2) {
            return;
        }
        else if(cadastrar == 1) {
            cadastrarAluno(scanner, alunos);
        }
        else {
            System.out.println("\nValor inválido...");
            System.out.println("Gostaria de cadastrar outro Aluno?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            scanner.nextLine();
        }
    }

    public static void listarAlunos(ArrayList<Aluno> alunos) {
        if(alunos.size() == 0) {
            System.out.println("\n\tAinda não há Alunos cadastrados...");
            System.out.println("\tRetornando ao Menu Principal...\n");
            return;
        }
        else {
            System.out.println();
            System.out.println("\n--------------------------------------------------------");
            System.out.println("\t\t ALUNOS");
            System.out.println("--------------------------------------------------------");

            alunos.forEach((aluno) -> System.out.println(aluno + "\n"));
        }
    }
}