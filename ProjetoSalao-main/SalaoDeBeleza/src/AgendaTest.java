import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AgendaTest {

    private Agenda agenda;
    private Servico servico;

    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
        servico = new Servico();
        servico.setNome("Corte de cabelo");
    }

    @Test
    public void testValidarDisponibilidade_DataDisponivel() {
        boolean disponivel = agenda.validarDisponibilidade("2024-10-24", servico);
        assertTrue(disponivel, "A data deveria estar disponível para o serviço.");
    }

    @Test
    public void testValidarDisponibilidade_DataIndisponivel() {

        Agenda agendamento = new Agenda();
        agendamento.setData("2024-10-24");
        agendamento.setServico("Corte de cabelo");
        agendamento.setNomeCliente("Cliente 1");


        ArrayList<Agenda> agendas = new ArrayList<>();
        agendas.add(agendamento);
        agenda.setAgendas(agendas);


        boolean disponivel = agenda.validarDisponibilidade("2024-10-24", servico);
        assertFalse(disponivel, "A data não deveria estar disponível, pois já foi agendada para o mesmo serviço.");
    }

    @Test
    public void testAdicionarAgendamento() {

        Agenda agendamento = new Agenda();
        agendamento.setData("2024-11-15");
        agendamento.setServico("Corte de cabelo");
        agendamento.setNomeCliente("Cliente 2");

        agenda.getAgendas().add(agendamento);


        assertEquals(1, agenda.getAgendas().size(), "Deveria ter 1 agendamento na lista.");
        assertEquals("Cliente 2", agenda.getAgendas().get(0).getNomeCliente(), "O nome do cliente não coincide.");
    }

    @Test
    public void testListarAgendamentos() {

        Agenda agendamento1 = new Agenda();
        agendamento1.setData("2024-11-20");
        agendamento1.setServico("Corte de cabelo");
        agendamento1.setNomeCliente("Cliente 3");

        agenda.getAgendas().add(agendamento1);


        agenda.listarAgendamentos();
    }
}
