package Controller;

import Model.Medicamento;
import Model.Medico;

import java.util.ArrayList;

public class MedicamentoController {
    private static final ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public String salvarMedicamento(Medicamento remedio) {
        if(pesquisarMedicamentoPorNome(remedio.getNome()) == null){
            Medico medico = MedicoController.mostrarMedico();
            if(medico.getCrm() != null){
                remedio.setMedico(medico);
                this.medicamentos.add(remedio);
                return "Medicamento Cadastrado com sucesso";
            }else{
                return "Médico não cadastrado";
            }
        }
        return "";
    }

    public static Medicamento pesquisarMedicamentoPorNome(String nome){
        for (int i = 0; i < medicamentos.size(); i++){
            if(medicamentos.get(i).getNome().equalsIgnoreCase(nome)){
                return medicamentos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Medicamento> listarMedicamentos(){
        if(this.medicamentos.isEmpty()){
            return null;
        }else{
            return this.medicamentos;
        }
    }
}
