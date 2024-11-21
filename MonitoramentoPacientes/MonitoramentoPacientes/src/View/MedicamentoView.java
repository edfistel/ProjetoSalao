package View;

import Controller.MedicamentoController;
import Model.Medicamento;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicamentoView {
    private Scanner ler = new Scanner(System.in);
    private static MedicamentoController controller = new MedicamentoController();
    public void cadastrarMedicamento() {
        Medicamento remedio = new Medicamento();
        LimpaTela.limparTela();
        System.out.println("Registrar novo medicamento: ");
        System.out.println("Nome: ");
        remedio.setNome(ler.next());
        System.out.println("Dosagem: ");
        remedio.setDosagem(ler.nextDouble());
        System.out.println("Frequência: ");
        remedio.setFrequencia(ler.nextInt());
        System.out.println("Descrição: ");
        remedio.setDescricao(ler.next());
        System.out.println("CRM do médico");
        remedio.getMedico().setCrm(ler.next());
        System.out.println("Data da criação da Prescrição: ");
        remedio.setDataPescricao(ler.next());
        System.out.println(controller.salvarMedicamento(remedio));
        MenuView.mostrarMenuPrincipal();
    }

    public static  void listarMedicamentos() {

        ArrayList<Medicamento> medicamentos = controller.listarMedicamentos();
        System.out.println("Medicamentos ");
        if( medicamentos == null){
            System.out.println("Nenhum medicamento cadastrado");
            MenuView.mostrarMenuPrincipal();
        }else{
            for (Medicamento medicamento : medicamentos) {
                System.out.println("Nome: " + medicamento.getNome());
                System.out.println("Frequência: " + medicamento.getFrequencia());
                System.out.println("Dosagem: " + medicamento.getDosagem());
                System.out.println("Descrição: " + medicamento.getDescricao());
                System.out.println("Data Descrição: " + medicamento.getDataPescricao());
                System.out.println("Nome do Médico: " + medicamento.getMedico().getNome());
                System.out.println("CRM: " + medicamento.getMedico().getCrm() + "\n");

            }
            MenuView.mostrarMenuPrincipal();
        }
    }
}
