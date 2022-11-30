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
        int assiduidade = 0;

        Aluno aluno = new Aluno();


        System.out.println("Informe a matrícula do Aluno: ");
        if(scanner.hasNextInt()) {
            matricula = scanner.nextInt();
            aluno.setMatricula(matricula);
            scanner.nextLine();
        }
        else {
            System.out.println("\n\tValor inválido...");
            System.out.println("\tPermitido somente números inteiros...");
            System.out.println("\tRetornando ao Menu Principal...\n");
            scanner.nextLine();
            return;
        }

        System.out.println("Informe o Nome do Aluno: ");
        if(scanner.hasNextLine()) {
            nome = scanner.nextLine();
            aluno.setNome(nome);
        }

        System.out.println("Informe as Notas do Aluno...");
        for (int i = 0; i < notas.length; i++){
            double nota = 0;
            System.out.printf("Nota da prova %d: ", i + 1);
            if(scanner.hasNextDouble()) {
                nota = scanner.nextDouble();
                scanner.nextLine();
                if(nota >= 0 && nota <= 100){
                    notas[i] = nota;
                }
                else {
                    System.out.println("\n\tValor inválido...");
                    System.out.println("\tInforme um número inteiro de 0 a 100...");
                    System.out.println("\tRetornando ao Menu Principal...\n");
                    return;
                }
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tPermitido somente números...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                scanner.nextLine();
                return;
            }
        }
        aluno.setNotas(notas);


        System.out.println("Informe o número de presenças do Aluno nas 60 aulas: ");
        if(scanner.hasNextInt()) {
            assiduidade = scanner.nextInt();
            scanner.nextLine();

            if(assiduidade >= 0 && assiduidade <= 60){
                aluno.setAssiduidade(assiduidade);
                aluno.setPercentualDeFrequencia();
            }
            else {
                System.out.println("\n\tValor inválido...");
                System.out.println("\tInforme um número inteiro de 0 a 60...");
                System.out.println("\tRetornando ao Menu Principal...\n");
                return;
            }
        }
        else {
            System.out.println("\n\tValor inválido...");
            System.out.println("\tPermitido somente números inteiros...");
            System.out.println("\tRetornando ao Menu Principal...\n");
            scanner.nextLine();
            return;
        }

        alunos.add(aluno);

        System.out.println("\nAluno cadastrado com sucesso: ");
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