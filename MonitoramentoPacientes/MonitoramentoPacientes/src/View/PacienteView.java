package View;

import Controller.PacienteController;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class PacienteView {
    private Scanner ler = new Scanner(System.in);
    private PacienteController controller;

    public PacienteView(PacienteController controlador) {
        this.controller = controlador;
    }

    public void cadastrarPaciente(){
        LimpaTela.limparTela();
        Paciente paciente1 = new Paciente();
        System.out.println("Cadastre um novo Paciente ");
        System.out.println("Nome: ");
        paciente1.setNome(ler.next());
        System.out.println("Cpf: ");
        paciente1.setCpf(ler.next());
        System.out.println("Data Nascimento: ");
        paciente1.setDataNasc(ler.next());
        System.out.println("Endereco: ");
        paciente1.setEndereco(ler.next());
        System.out.println("Telefone: ");
        paciente1.setTelefone(ler.next());
        System.out.println("E-mail: ");
        paciente1.setEmail(ler.next());
        System.out.println("Histórico: ");
        paciente1.setHistorico(ler.next());
        System.out.println(controller.cadastrarPaciente(paciente1));
        MenuView.mostrarMenuPrincipal();
    }

    public void listarPaciente() {
        LimpaTela.limparTela();
        ArrayList<Paciente> pacientes = controller.listarPaciente();
        if(pacientes.isEmpty()){
            System.out.println("Nenhum paciente encontrado");
            MenuView.mostrarMenuPrincipal();
        }else{
            for (Paciente pac : pacientes) {
                System.out.println("Nome: " + pac.getNome());
                System.out.println("Cpf: " + pac.getCpf());
                System.out.println("Email: " + pac.getEmail());
                System.out.println("Telefone: " + pac.getTelefone());
                System.out.println("Data de Nascimento: " + pac.getDataNasc());
                System.out.println("Endereço: " + pac.getEndereco());
                System.out.println("Dispositivo: " + pac.getDispositivo().getModelo());
                System.out.println("Medicamentos: " + pac.getMedicamento().getNome());
                System.out.println("Histórico: " + pac.getHistorico() + "\n");
            }
        }
        MenuView.mostrarMenuPrincipal();
    }

    public void consultarPaciente(Byte opcao){
        LimpaTela.limparTela();
        System.out.println("Digite o CPF do paciente que voce deseja: ");

        String cpf = ler.next();
       if(opcao == 6){
           controller.mostrarHistoricoPaciente(cpf);
       } else if (opcao == 7) {
           alterarPaciente(cpf);
       }
    }
    private void alterarPaciente(String cpf){
        Paciente paciente2 = new Paciente();
        LimpaTela.limparTela();
        System.out.println("Cadastre um novo Paciente ");
        System.out.println("Nome: ");
        paciente2.setNome(ler.next());
        System.out.println("Cpf: ");
        paciente2.setCpf(ler.next());
        System.out.println("Data Nascimento: ");
        paciente2.setDataNasc(ler.next());
        System.out.println("Endereco: ");
        paciente2.setEndereco(ler.next());
        System.out.println("Telefone: ");
        paciente2.setTelefone(ler.next());
        System.out.println("E-mail: ");
        paciente2.setEmail(ler.next());
        System.out.println("Histórico: ");
        paciente2.setHistorico(ler.next());
        System.out.println(controller.alterarPaciente(cpf,paciente2));
        MenuView.mostrarMenuPrincipal();
    }


    public static void mostrarHistoricoPaciente(Paciente paciente){
        LimpaTela.limparTela();
       if(paciente == null){
           System.out.println("Nenhum paciente encontrado");
           MenuView.mostrarMenuPrincipal();
       }else{
           System.out.println("Paciente Consultado");
           System.out.println("Nome: " + paciente.getNome());
           System.out.println("Cpf: " + paciente.getCpf());
           System.out.println("Histórico: " + paciente.getHistorico());
           MenuView.mostrarMenuPrincipal();
       }
    }
}
