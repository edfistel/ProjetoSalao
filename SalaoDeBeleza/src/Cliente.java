import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isValid(Cliente cliente){
        if (cliente.getNome() != null && cliente.getEndereco() !=null && cliente.getEmail() !=null && cliente.getTelefone() !=null){
            return true;
        }
        return false;
    }

    public Cliente validarClientePorNome(String nome){
        for (int i = 0; i < this.clientes.size(); i++){
            if(clientes.get(i).getNome().equals(nome)){
                return clientes.get(i);
            }
        }
        return null;
    }

    public void listarClientes(){
        for (int i =0; i < this.clientes.size(); i++){
            System.out.println("\nClientes: \n");
            System.out.println("Nome: " + clientes.get(i).getNome());
            System.out.println("Email: " + clientes.get(i).getEmail());
            System.out.println("Telefone: " + clientes.get(i).getTelefone());
            System.out.println("Endereco: " + clientes.get(i).getEndereco());
            System.out.println("");
        }
    }
}
