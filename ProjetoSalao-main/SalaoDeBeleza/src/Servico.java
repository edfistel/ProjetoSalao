import java.util.ArrayList;

public class Servico {
    private String nome;
    private String descricao;
    private Double valor;
    private ArrayList<Servico> servicos = new ArrayList<>();

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

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
        if (servico.getNome() !=null && servico.getValor() != null && servico.getDescricao() != null){
            return true;
        }
        return false;
    }

    public Servico pesquisarServicoPorNome(Servico servico){
        for (int i =0; i < this.servicos.size(); i++){
            if (this.servicos.get(i).getNome().equals(servico.getNome())){
                return servicos.get(i);
            }
        }
        return null;
    }

    public void listarServicos(){
        for (int i =0; i < this.servicos.size(); i++){
            System.out.println("\nServicos: \n");
            System.out.println("Nome: " + servicos.get(i).getNome());
            System.out.println("Descrição: " + servicos.get(i).getDescricao());
            System.out.println("Valor: " + servicos.get(i).getValor());
            System.out.println("");
        }
    }
}
