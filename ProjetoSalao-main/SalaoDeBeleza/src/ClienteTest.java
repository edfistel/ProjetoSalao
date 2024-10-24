import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
    }

    @Test
    public void testIsValid_ClienteValido() {
        Cliente clienteValido = new Cliente();
        clienteValido.setNome("João");
        clienteValido.setEmail("joao@example.com");
        clienteValido.setTelefone("99999-9999");
        clienteValido.setEndereco("Rua A, 123");


        assertTrue(cliente.isValid(clienteValido), "O cliente deveria ser considerado válido.");
    }

    @Test
    public void testIsValid_ClienteInvalido() {
        Cliente clienteInvalido = new Cliente();
        clienteInvalido.setEmail("invalido@example.com");
        clienteInvalido.setTelefone("99999-8888");
        clienteInvalido.setEndereco("Rua B, 456");


        assertFalse(cliente.isValid(clienteInvalido), "O cliente deveria ser considerado inválido.");
    }

    @Test
    public void testValidarClientePorNome() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Carlos");
        cliente1.setEmail("carlos@example.com");
        cliente1.setTelefone("99999-7777");
        cliente1.setEndereco("Rua C, 789");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Ana");
        cliente2.setEmail("ana@example.com");
        cliente2.setTelefone("99999-6666");
        cliente2.setEndereco("Rua D, 123");

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        cliente.setClientes(listaClientes);


        Cliente resultado = cliente.validarClientePorNome("Ana");
        assertNotNull(resultado, "Cliente deveria ser encontrado.");
        assertEquals("Ana", resultado.getNome(), "O nome do cliente encontrado está incorreto.");
    }


}
