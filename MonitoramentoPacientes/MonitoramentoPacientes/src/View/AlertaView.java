package View;

import Controller.AlertaController;
import Model.Alerta;

import java.util.ArrayList;
import java.util.Scanner;

public class AlertaView {
    private Scanner ler = new Scanner(System.in);
    private AlertaController controller = new AlertaController();

    public void listarAlertas(){
        ArrayList<Alerta> lista = controller.listarAlertas();
        LimpaTela.limparTela();
        System.out.println("Alertas");
        System.out.println("");
        for(int i = 0; i < lista.size(); i++){
            System.out.println("Tipo: " + lista.get(i).getTipo());
            System.out.println("Data: " + lista.get(i).getData());
            System.out.println("Mensagem: " + lista.get(i).getMensagem());
            System.out.println("Médico: " + lista.get(i).getMedico().getNome());
            System.out.println("Paciente: " + lista.get(i).getPaciente().getNome());
            System.out.println("Dispositivo monitorado: " + lista.get(i).getMonitoramento().getDispositivo().getModelo());
        }
        MenuView.mostrarMenuPrincipal();
    }

    public void alterarAlerta(){
        LimpaTela.limparTela();
        Alerta alertaLocalizar = new Alerta();
        Alerta alertaAlterar = new Alerta();
        //Dados que serão utilizados para localizar o alerta
        System.out.println("Digite o CRM do médico atrelado ao alerta: ");
        alertaLocalizar.getMedico().setCrm(ler.next());
        System.out.println("Digite o CPF do paciente atrelado ao alerta: ");
        alertaLocalizar.getPaciente().setCpf(ler.next());
        System.out.println("Digite o modelo do dispositivo monitorado atrelado ao alerta: ");
        alertaLocalizar.getMonitoramento().getDispositivo().setModelo(ler.next());

        //Dados que serão alterados no alerta
        System.out.println("Digite a mensagem do Alerta: ");
        alertaAlterar.setMensagem(ler.next());
        System.out.println("Digite um novo CRM do Médico caso queira alterar: ");
        alertaAlterar.getMedico().setCrm(ler.next());
        System.out.println("Digite um novo modelo de dispositivo caso queira alterar: ");
        alertaLocalizar.getMonitoramento().getDispositivo().setModelo(ler.next());
        controller.alterarAlerta(alertaLocalizar,alertaAlterar);
        MenuView.mostrarMenuPrincipal();
    }

    public void removerAlerta() {
        LimpaTela.limparTela();
        Alerta alertaLocalizar = new Alerta();

        // Dados para localizar o alerta
        System.out.println("Digite o CRM do médico atrelado ao alerta: ");
        alertaLocalizar.getMedico().setCrm(ler.next());
        System.out.println("Digite o CPF do paciente atrelado ao alerta: ");
        alertaLocalizar.getPaciente().setCpf(ler.next());
        System.out.println("Digite o modelo do dispositivo monitorado atrelado ao alerta: ");
        alertaLocalizar.getMonitoramento().getDispositivo().setModelo(ler.next());

        // Chama o controlador para remover o alerta
        controller.removerAlerta(alertaLocalizar);
        MenuView.mostrarMenuPrincipal();
    }
}
