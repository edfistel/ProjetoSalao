package Model;

public class Medicamento {
    private String nome;
    private double dosagem;
    private int frequencia;
    private String descricao;
    private Medico medico;
    private  String dataPescricao;

    public Medicamento() {
        this.medico = new Medico();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDataPescricao() {
        return dataPescricao;
    }

    public void setDataPescricao(String dataPescricao) {
        this.dataPescricao = dataPescricao;
    }
}
