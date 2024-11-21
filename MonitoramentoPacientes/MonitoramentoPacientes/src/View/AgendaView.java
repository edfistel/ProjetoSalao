package View;

import Controller.AgendaController;
import Model.Agenda;
import Model.Medicamento;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaView {
    private Scanner ler = new Scanner(System.in);
    private AgendaController agendaController =  new AgendaController();

    public void fazerAgendamento(){
        LimpaTela.limparTela();
        Agenda agenda = new Agenda();
        System.out.println("Fazer um novo agendamento \n"
        +"Data: ");
        agenda.setData(ler.next());
        System.out.println("Hora: ");
        agenda.setHora(ler.next());
        System.out.println("CPF do paciente: ");
        agenda.getPaciente().setCpf(ler.next());
        System.out.println("CRM do Médico: ");
        agenda.getMedico().setCrm(ler.next());
        System.out.println(agendaController.cadastrarAgendamento(agenda));
        MenuView.mostrarMenuPrincipal();
    }

    public void listarAgendas(){
        ArrayList<Agenda> agenda = agendaController.listarAgenda();
        if(agenda == null){
            System.out.println("Nenhum agendamento cadastrado");
            MenuView.mostrarMenuPrincipal();
        }else{
            System.out.println("Agendas: \n");
            for (int i = 0; i < agenda.size(); i++){
                System.out.println("\nData: " + agenda.get(i).getData());
                System.out.println("Hora: " + agenda.get(i).getHora());
                System.out.println("\n Informações do Médico: \n");
                System.out.println("Nome: " + agenda.get(i).getMedico().getNome());
                System.out.println("CRM: " + agenda.get(i).getMedico().getCrm());
                System.out.println("\n Informações do Paciente: \n");
                System.out.println("Nome: " + agenda.get(i).getPaciente().getNome());
                System.out.println("CPF: " + agenda.get(i).getPaciente().getCpf());
                System.out.println("Histórico: " + agenda.get(i).getPaciente().getHistorico());
                System.out.println("\nDiagnóstico: " + agenda.get(i).getDiagnostico());
                System.out.println("\nDescrição da prescricão: " + agenda.get(i).getPrescricao());
                MedicamentoView.listarMedicamentos();
                MenuView.mostrarMenuPrincipal();
            }
        }
    }


    public void adicionarPrescricao() {
        LimpaTela.limparTela();
        Agenda agenda = new Agenda();

        System.out.println("Digite a data da consulta que deseja cadastrar uma prescrição: ");
        agenda.setData(ler.next());
        System.out.println("Digite a hora: ");
        agenda.setHora(ler.next());
        System.out.println("Digite a descrição da prescrição médica: ");
        agenda.setPrescricao(ler.next());

        // Inicializa o paciente e o medicamento, se necessário
        if (agenda.getPaciente() == null) {
            agenda.setPaciente(new Paciente()); // Inicializa um novo Paciente
        }
        if (agenda.getPaciente().getMedicamento() == null) {
            agenda.getPaciente().setMedicamento(new Medicamento()); // Inicializa um novo Medicamento
        }

        System.out.println("Digite o nome do medicamento: ");
        agenda.getPaciente().getMedicamento().setNome(ler.next());

        do {
            System.out.println("Deseja salvar a prescrição?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            System.out.println("Digite aqui: ");
            byte op = ler.nextByte();

            switch (op) {
                case 1:
                    System.out.println(agendaController.salvarPrescricao(agenda));
                    MenuView.mostrarMenuPrincipal();
                    break;
                case 2:
                    MenuView.mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; // Volta ao início do loop para repetir a entrada
            }
            break; 
        } while (true);
    }

    public void adicionarDiagnostico() {
        LimpaTela.limparTela();
        Agenda agenda = new Agenda();
        System.out.println("Digite a data da consulta que deseja cadastrar um diagnóstico: ");
        agenda.setData(ler.next());
        System.out.println("Digite a hora: ");
        agenda.setHora(ler.next());
        System.out.println("Digite o diagnóstico médica: ");
        agenda.setPrescricao(ler.next());
        System.out.println(agendaController.salvarDignostico(agenda));
        MenuView.mostrarMenuPrincipal();
    }
}
