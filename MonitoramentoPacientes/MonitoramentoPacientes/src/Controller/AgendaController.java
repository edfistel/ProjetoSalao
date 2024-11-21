package Controller;

import Model.Agenda;
import Model.Medicamento;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Objects;

public class AgendaController {
    private  ArrayList<Agenda> agendas = new ArrayList<Agenda>();

    public String cadastrarAgendamento(Agenda agenda) {
        Agenda ag = pesquisarAgendaPorData(agenda.getData());
        Paciente paciente = PacienteController.pesquisarPacienteporCpf(agenda.getPaciente().getCpf());
        Medico medico = MedicoController.mostrarMedico();

        if(medico == null){
            return "Médico não cadastrado";
        }else{
            agenda.setMedico(medico);

        }
        if(paciente == null){
            return "Paciente não cadastrado";
        }else{
            agenda.setPaciente(paciente);
        }

        //Se o método retornar null, significa que não tem nenhuma agenda cadastrada com essa data. então faz o cadastro.
        if(ag == null){
            this.agendas.add(agenda);
            return "Agendamento cadastrado com sucesso";
            //Se o método for diferente de null, então tem alguma agenda com está data. então devemos comparar se o horário agendado é o mesmo do novo agendamento, caso seja igual retorna erro.
        }else if(ag.getHora().equalsIgnoreCase(agenda.getHora()) && ag.getData().equalsIgnoreCase(agenda.getData())){
            return  "Essa data/horário ja está agendada";
            //Se a data for igual mas a hora for diferente,deixa cadastrar.
        }else if(!Objects.equals(ag.getHora(), agenda.getHora()) && ag.getData().equalsIgnoreCase(agenda.getData())){
            this.agendas.add(agenda);
            return "Agendamento cadastrado com sucesso";
        }else{
            return "Erro";
        }

    }

    public ArrayList<Agenda> listarAgenda(){
        if(this.agendas.isEmpty()){
            return null;
        }else{
            return this.agendas;
        }
    }
    public  Agenda pesquisarAgendaPorData(String data){
        for (Agenda agenda : agendas){
            if(agenda.getData().equalsIgnoreCase(data)){
                return agenda;
            }
        }
        return null;
    }

    public String salvarPrescricao(Agenda agenda) {
        Agenda ag = pesquisarAgendaPorData(agenda.getData());
        if (ag == null) {
            return "Nenhum agendamento encontrado";
        }
        for (int i = 0; i < this.agendas.size(); i++) {
            Agenda agendamentoExistente = this.agendas.get(i);
            if (agendamentoExistente.getHora().equalsIgnoreCase(agenda.getHora()) && agendamentoExistente.getData().equalsIgnoreCase(agenda.getData())) {

                // Busca o medicamento para verificar se existe no sistema
                Medicamento medicamentoEncontrado = MedicamentoController.pesquisarMedicamentoPorNome(agenda.getPaciente().getMedicamento().getNome());
                if (medicamentoEncontrado != null && medicamentoEncontrado.getNome().equalsIgnoreCase(agenda.getPaciente().getMedicamento().getNome())) {
                    // Atualiza o medicamento do paciente e salva a prescrição no agendamento correspondente
                    agenda.getPaciente().setMedicamento(medicamentoEncontrado);
                    agendamentoExistente.setPrescricao(agenda.getPrescricao());

                    return "Prescrição salva com sucesso";
                } else {
                    return "Erro: Medicamento não encontrado no sistema";
                }
            }
        }

        return "Erro: Nenhum agendamento encontrado na data e hora especificadas";
    }

    public String salvarDignostico(Agenda agenda) {
        Agenda ag = pesquisarAgendaPorData(agenda.getData());
        if(ag == null){
            return "Nenhum agendamento encontrado";
        } else if (ag.getHora().equalsIgnoreCase(agenda.getHora())) {
            for(int i = 0; i < this.agendas.size(); i++){
                if(this.agendas.get(i).getHora().equalsIgnoreCase(agenda.getHora()) && this.agendas.get(i).getData().equalsIgnoreCase(agenda.getData())){
                    this.agendas.get(i).setDiagnostico(agenda.getDiagnostico());
                    return"Pescrição salva com sucesso";
                }else{
                    return "Erro ao salvar a prescrição";
                }
            }
        }
        return "";
    }
}
