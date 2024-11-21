package Controller;

import Model.Medico;

public class MedicoController {
    private Medico medico = new Medico();
    public String cadastrarMedico(Medico medico) {
        if(medico != null){
            this.medico = medico;
            return"Médico cadastrado com sucesso";
        }else{
            return "Preencha todos os campos";
        }
    }

    public Medico mostrarMedico(){
        return this.medico;
    }

    public String alterarMedico(Medico medico) {
        if(medico != null){
            this.medico = medico;
            return"Médico alterado com sucesso";
        }else{
            return "Preencha todos os campos";
        }
    }
}
