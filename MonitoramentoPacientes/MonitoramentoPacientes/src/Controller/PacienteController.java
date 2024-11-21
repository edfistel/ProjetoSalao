package Controller;

import Model.Dispositivo;
import Model.Medicamento;
import Model.Paciente;
import View.PacienteView;

import java.util.ArrayList;

public class PacienteController {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public String cadastrarPaciente(Paciente paciente) {
       if(validarPacienteCpf(paciente)){
           return "Paciente ja cadastrado";
       }else{
           paciente.setMedicamento(new Medicamento());
           paciente.setDispositivo(new Dispositivo());
           pacientes.add(paciente);
           return "Paciente cadastrado com sucesso";
       }
    }

    public ArrayList<Paciente> listarPaciente(){
       return pacientes;
    }

    public  Boolean validarPacienteCpf(Paciente paciente) {
        for (Paciente pac : pacientes) {
            if (pac.getCpf().equals(paciente.getCpf())) {
                return true; // CPF duplicado encontrado
            }
        }
        return false;
    }
    public void mostrarHistoricoPaciente(String cpf){
        Paciente paciente = pesquisarPacienteporCpf(cpf);
        PacienteView.mostrarHistoricoPaciente(paciente);
    }
    public  static Paciente pesquisarPacienteporCpf(String cpf){
        for (Paciente pac : pacientes) {
            if (pac.getCpf().equals(cpf)) {
                return pac;
            }
        }
        return null;
    }

    public String alterarPaciente(String cpf, Paciente paciente2){
        Paciente paciente = pesquisarPacienteporCpf(cpf);
        if(paciente == null){
            return "Nenhum paciente encontrado";
        }else{
            for(int i = 0; i < this.pacientes.size(); i++){
                if(this.pacientes.get(i).getCpf().equals(cpf)){
                    this.pacientes.set(i,paciente2);
                    return "Paciente alterado com Sucesso";
                }
            }
        }
        return "Erro ao alterar o paciente";
    }
}
