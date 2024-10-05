public class Servico {
    private String nome;
    private String descricao;
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isValid(Servico servico){
        if (!servico.getNome().isEmpty() && servico.getValor() != null && !servico.getDescricao().isEmpty()){
            return true;
        }
        return false;
    }
}
