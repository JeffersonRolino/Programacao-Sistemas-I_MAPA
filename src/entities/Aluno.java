package entities;

public class Aluno {
    private int matricula;
    private String nome;
    private double[] notas;
    private char[] assiduidade;

    //Constructors
    public Aluno() {
        this.notas = new double[3];
        this.assiduidade = new char[60];
    }

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new double[3];
        this.assiduidade = new char[60];
    }

    public Aluno(int matricula, String nome, double[] notas, char[] assiduidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
        this.assiduidade = assiduidade;
    }

    //Getters and Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public char[] getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(char[] assiduidade) {
        this.assiduidade = assiduidade;
    }
}
