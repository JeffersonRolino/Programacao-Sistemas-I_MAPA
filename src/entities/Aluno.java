package entities;

public class Aluno {
    private int matricula;
    private String nome;
    private double[] notas;
    private int assiduidade;
    private double percentualDeFrequencia;

    //Constructors
    public Aluno() {
    }

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new double[3];
    }

    public Aluno(int matricula, String nome, double[] notas, int assiduidade, double percentualDeFrequencia) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
        this.assiduidade = assiduidade;
        this.percentualDeFrequencia = percentualDeFrequencia;
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

    public int getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(int assiduidade) {
        this.assiduidade = assiduidade;
    }

    public double getPercentualDeFrequencia() {
        return percentualDeFrequencia;
    }

    public void setPercentualDeFrequencia() {
        this.percentualDeFrequencia = ((double)this.assiduidade / 60) * 100;
    }

    //Métodos
    public double calcularMediaNotas(double[] notas){
        double soma = 0;
        for (int i = 0; i < notas.length; i++){
            soma += notas[i];
        }
        return soma / 3;
    }

    @Override
    public String toString() {
        return String.format("""
                        Aluno: %s
                        Média: %.2f\s
                        Percentual de Presença: %.2f""",
                this.nome,
                calcularMediaNotas(this.notas),
                this.percentualDeFrequencia
        ) + "%";
    }
}
