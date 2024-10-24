import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoTest {
    private Servico servico = new Servico();
    @Test
    void pesquisarServicoPorNome() {
        Servico servico1 = new Servico();
        servico1.setNome("Corte de cabelo");
        servico1.setDescricao("corte");
        servico1.setValor(20.00);
        servico.getServicos().add(servico1);
        Servico resultado =servico.pesquisarServicoPorNome(servico1);
        assertNotNull(resultado,"Serviço deve ser diferente de null");
        assertEquals("Corte de cabelo",resultado.getNome());
    }
}