package Model;

public class Monitoramento {
    private Paciente paciente;
    private Dispositivo dispositivo;

    public Monitoramento() {
        this.paciente = new Paciente();
        this.dispositivo = new Dispositivo();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
