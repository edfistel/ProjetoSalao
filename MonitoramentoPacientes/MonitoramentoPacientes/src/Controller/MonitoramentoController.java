package Controller;

import Model.Alerta;
import Model.Dispositivo;
import Model.Monitoramento;
import Model.Paciente;

import java.util.ArrayList;

public class MonitoramentoController {
    private ArrayList<Monitoramento> monitoramentos = new ArrayList<>();

    public String adicionarMonitoramento(Dispositivo dispositivo, Paciente paciente) {
        Alerta alerta = new Alerta();
        Paciente pac = PacienteController.pesquisarPacienteporCpf(paciente.getCpf());
        if (pac == null) {
            return "Nenhum paciente encontrado";
        }

        Dispositivo disp = DispositivoController.pesquisarDispositivoPorTipo(dispositivo.getTipo());
        if (disp == null) {
            return "Nenhum dispositivo encontrado";
        }

        dispositivo.setModelo(disp.getModelo());
        dispositivo.setMarca(disp.getMarca());
        dispositivo.setStatus(disp.isStatus());
        Monitoramento monitoramento = new Monitoramento();
        monitoramento.setPaciente(pac);
        monitoramento.setDispositivo(dispositivo);
        this.monitoramentos.add(monitoramento);

        alerta.setMedico(MedicoController.mostrarMedico());
        alerta.setPaciente(pac);
        alerta.setMonitoramento(monitoramento);
        AlertaController.gerarAlertas(alerta);
        return "Monitoramento cadastrado com sucesso";
    }

    public ArrayList<Monitoramento> listarMonitoramentos(){
        if(this.monitoramentos.isEmpty()){
            return null;
        }else{
            return this.monitoramentos;
        }
    }

}
