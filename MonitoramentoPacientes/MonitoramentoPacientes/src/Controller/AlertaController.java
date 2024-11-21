package Controller;

import Model.Alerta;
import Model.Dispositivo;

import java.time.LocalDate;
import java.util.ArrayList;

public class AlertaController {
    private static ArrayList<Alerta> alertas = new ArrayList();

    public static void gerarAlertas(Alerta alerta) {
        Dispositivo dispOld = DispositivoController.pesquisarDispositivoPorTipo(alerta.getMonitoramento().getDispositivo().getTipo());
        double valorReferencia = dispOld.getValoresReferencia();
        double valorAtual = alerta.getMonitoramento().getDispositivo().getValoresReferencia();

        // Verifica se o valor atual está acima do limite de referência
        if (valorAtual > valorReferencia) {
            if (valorAtual >= valorReferencia * 1.02) { // Emergência se for 50% maior ou mais
                alerta.setTipo("Emergência");
            } else { // Alerta de anormalidade se for apenas maior
                alerta.setTipo("Anormalidade");
            }
        }
        // Verifica se o valor atual está abaixo do limite de referência
        else if (valorAtual < valorReferencia) {
            if (valorAtual <= valorReferencia * 0.02) { // Emergência se for 50% menor ou mais
                alerta.setTipo("Emergência");
            } else { // Alerta de anormalidade se for apenas menor
                alerta.setTipo("Anormalidade");
            }
        } else {
            // Caso esteja dentro dos valores de referência, nenhum alerta é necessário
            alerta.setTipo("Normal");
        }
        alerta.setData(LocalDate.now());
        alertas.add(alerta);
    }

    public  ArrayList<Alerta> listarAlertas(){
        return alertas;
    }

    public void alterarAlerta(Alerta alertaLocalizar, Alerta alertaAlterar) {
        for (Alerta alerta : alertas) {
            // Verifica se o alerta corresponde aos dados fornecidos
            if (alerta.getMedico().getCrm().equals(alertaLocalizar.getMedico().getCrm()) &&
                    alerta.getPaciente().getCpf().equals(alertaLocalizar.getPaciente().getCpf()) &&
                    alerta.getMonitoramento().getDispositivo().getModelo().equals(alertaLocalizar.getMonitoramento().getDispositivo().getModelo())) {

                // Aplica as alterações fornecidas
                if (alertaAlterar.getMensagem() != null && !alertaAlterar.getMensagem().isEmpty()) {
                    alerta.setMensagem(alertaAlterar.getMensagem());
                }
                if (alertaAlterar.getMedico() != null && alertaAlterar.getMedico().getCrm() != null) {
                    alerta.getMedico().setCrm(alertaAlterar.getMedico().getCrm());
                }
                if (alertaAlterar.getMonitoramento() != null &&
                        alertaAlterar.getMonitoramento().getDispositivo().getModelo() != null) {
                    alerta.getMonitoramento().getDispositivo().setModelo(alertaAlterar.getMonitoramento().getDispositivo().getModelo());
                }

                System.out.println("Alerta alterado com sucesso.");
                return;
            }
        }
        System.out.println("Alerta não encontrado.");
    }

    public void removerAlerta(Alerta alertaLocalizar) {
        for (Alerta alerta : alertas) {
            if (alerta.getMedico().getCrm().equals(alertaLocalizar.getMedico().getCrm()) &&
                    alerta.getPaciente().getCpf().equals(alertaLocalizar.getPaciente().getCpf()) &&
                    alerta.getMonitoramento().getDispositivo().getModelo().equals(alertaLocalizar.getMonitoramento().getDispositivo().getModelo())) {

                // Remove o alerta da lista
                alertas.remove(alerta);
                System.out.println("Alerta removido com sucesso.");
                return;
            }
        }
        System.out.println("Alerta não encontrado.");
    }
}
