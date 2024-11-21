package Controller;

import Model.Medico;

public class MedicoController {
    private static Medico medico = new Medico();
    public String cadastrarMedico(Medico medico) {
        if(medico != null){
            this.medico = medico;
            return"Médico cadastrado com sucesso";
        }else{
            return "Preencha todos os campos";
        }
    }

    public static Medico mostrarMedico(){
         return medico;

    }

    public String alterarMedico(Medico medico) {
        if(medico != null){
            if(this.medico == null){
                return "Cadastre um médico antes de tentar alterar";
            }else{
                this.medico = medico;
                return"Médico alterado com sucesso";
            }

        }else{
            return "Preencha todos os campos";
        }
    }
}
