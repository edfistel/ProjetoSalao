package Model;

import java.time.LocalDate;

public class Alerta {
    private String mensagem;
    private String tipo;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private Monitoramento monitoramento;

    public Alerta() {
        this.paciente = new Paciente();
        this.medico = new Medico();
        this.monitoramento = new Monitoramento();
    }

    public Monitoramento getMonitoramento() {
        return monitoramento;
    }

    public void setMonitoramento(Monitoramento monitoramento) {
        this.monitoramento = monitoramento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
