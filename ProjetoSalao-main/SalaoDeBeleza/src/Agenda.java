import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Agenda {
    private String nomeCliente;
    private String servico;
    private String data;

    private ArrayList<Agenda> agendas = new ArrayList<>();

    public ArrayList<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(ArrayList<Agenda> agendas) {
        this.agendas = agendas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Boolean validarDisponibilidade(String data,Servico servico){
        for (int i=0; i < this.agendas.size(); i++){
            if (agendas.get(i).getData().equals(data) && agendas.get(i).getServico().equals(servico.getNome())){
                return false;
            }
        }
        return true; //retorna verdadeiro se tiver a data disponivel para o serviço selecionado.
    }
    public void listarAgendamentos(){
        for (int i =0; i < this.agendas.size(); i++){
            System.out.println("\nAgendamentos: \n");
            System.out.println("Servico: " + agendas.get(i).getServico());
            System.out.println("Data: " + agendas.get(i).getData());
            System.out.println("Nome Do Cliente: " + agendas.get(i).getNomeCliente());
            System.out.println("");
        }
    }
}
