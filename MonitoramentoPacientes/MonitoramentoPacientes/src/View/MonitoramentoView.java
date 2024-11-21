package View;

import Controller.MonitoramentoController;
import Model.Dispositivo;
import Model.Medico;
import Model.Monitoramento;
import Model.Paciente;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MonitoramentoView {
    private Scanner ler = new Scanner(System.in);
    private MonitoramentoController controller = new MonitoramentoController();

    public void adicionarMonitoramento() {
        LimpaTela.limparTela();
        Dispositivo disp = new Dispositivo();
        Paciente paciente = new Paciente();
        System.out.println("Digite o tipo do Dispositivo: ");
        disp.setTipo(ler.next());
        System.out.println("Digite o valor capturado pelo dispositivo: ");
        disp.setValoresReferencia(ler.nextInt());
        System.out.println("Digite o CPF do paciente: ");
        paciente.setCpf(ler.next());

        System.out.println(controller.adicionarMonitoramento(disp,paciente));
        MenuView.mostrarMenuPrincipal();
    }

    public void listarMonitoramentos(){
        LimpaTela.limparTela();
        ArrayList<Monitoramento> lista = controller.listarMonitoramentos();
        System.out.println("Monitoramentos: ");
        if(lista != null){
            for(int i = 0; i < lista.size(); i++){
                System.out.println("Tipo: " + lista.get(i).getDispositivo().getTipo());
                System.out.println("Modelo: " + lista.get(i).getDispositivo().getModelo());
                System.out.println("Valor: " + lista.get(i).getDispositivo().getValoresReferencia());
                System.out.println("CPF: " + lista.get(i).getPaciente().getCpf());
                System.out.println("Nome: " + lista.get(i).getPaciente().getNome());
            }
            MenuView.mostrarMenuPrincipal();
        }
    }
}
