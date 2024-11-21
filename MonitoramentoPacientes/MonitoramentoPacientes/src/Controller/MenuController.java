package Controller;

import View.*;

public class MenuController {
    private PacienteController pacienteController = new PacienteController();
    private MedicamentoView medicamentoView = new MedicamentoView();
    private DispositivoView dispositivoView = new DispositivoView();
    private MedicoView medicoView = new MedicoView();
    private AlertaView alertaView = new AlertaView();
    private AgendaView agendaView = new AgendaView();
    private MonitoramentoView monitoramentoView = new MonitoramentoView();
    private PacienteView pacienteView = new PacienteView(pacienteController);
    public void validarOpcaoMenuPrincipal(byte op) {
        switch (op){
            case 1:
                medicoView.cadastrarMedico();
                break;
            case 2:
                medicoView.mostrarMedico();
                break;
            case 3:
                medicoView.alterarMedico();
                break;
            case 4:
                pacienteView.cadastrarPaciente();
                break;
            case 5:
                pacienteView.listarPaciente();
                break;
            case 6:
                pacienteView.consultarPaciente(op);
                break;
            case 7:
                pacienteView.consultarPaciente(op);
                break;
            case 8:
                agendaView.fazerAgendamento();
                break;
            case 9:
                agendaView.listarAgendas();
                break;
            case 10:
                agendaView.adicionarPrescricao();
                break;
            case 11:
                agendaView.adicionarDiagnostico();
                break;
            case 12:
                medicamentoView.cadastrarMedicamento();
                break;
            case 13:
                medicamentoView.listarMedicamentos();
                break;
            case 14:
                dispositivoView.cadastrarDispositivo();
                break;
            case 15:
                dispositivoView.listarDispositivos();
                break;
            case 16:
                dispositivoView.removerDispositivo();
                break;
            case 17:
                monitoramentoView.adicionarMonitoramento();
                break;
            case 18:
                monitoramentoView.listarMonitoramentos();
                break;
            case 19:
                //Existe apenas para o usuário achar que tem o controle de gerar alertas, mas o código gera o alerta sozinho. O usuário apenas altera ele
                MenuView.mensagem("Alertas Criados com sucesso!");
                break;
            case 20:
                alertaView.listarAlertas();
                break;
            case 21:
                alertaView.removerAlerta();
                break;
            case 22:
                alertaView.alterarAlerta();
                break;
            case 23:
                MenuView.mensagem("Programa encerrado com sucesso!!");
                break;
            default:

        }
    }



}
