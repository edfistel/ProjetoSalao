package View;

import Controller.MedicoController;
import Model.Medico;

import java.util.Scanner;

import static View.LimpaTela.limparTela;

public class MedicoView {
    private Scanner ler = new Scanner(System.in);
    private MedicoController controller = new MedicoController();
    private Medico medico = new Medico();
    public void cadastrarMedico(){

        limparTela();
        System.out.println("Cadastrar novo Médico"
                +"\n Digite o nome do médico: ");
        medico.setNome(ler.next());
        System.out.println("Digite a especialidade do médico: ");
        medico.setEspecialidade(ler.next());
        System.out.println("Digite o CRM: ");
        medico.setCrm(ler.next());
        System.out.println("Email: ");
        medico.setEmail(ler.next());
        System.out.println("Telefone: ");
        medico.setTelefone(ler.next());
        System.out.println(controller.cadastrarMedico(medico));
        MenuView.mostrarMenuPrincipal();
    }

    public void mostrarMedico(){
        limparTela();
        Medico medico = controller.mostrarMedico();
        System.out.println("Dados do Médico atual");
        System.out.println("Nome: " + medico.getNome());
        System.out.println("E-mail: " + medico.getEmail());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialidade: " + medico.getEspecialidade());
        System.out.println("Telefone: " + medico.getTelefone());
        MenuView.mostrarMenuPrincipal();
    }

    public void alterarMedico(){
        System.out.println("Digite novamente os dados do médico" +
                "\n Digite o nome do médico: ");
        medico.setNome(ler.next());
        System.out.println("Digite a especialidade do médico: ");
        medico.setEspecialidade(ler.next());
        System.out.println("Digite o CRM: ");
        medico.setCrm(ler.next());
        System.out.println("Email: ");
        medico.setEmail(ler.next());
        System.out.println("Telefone: ");
        medico.setTelefone(ler.next());
        System.out.println(controller.alterarMedico(medico));
        MenuView.mostrarMenuPrincipal();
    }
}
