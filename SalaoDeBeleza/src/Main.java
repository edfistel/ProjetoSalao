import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Agenda agenda = new Agenda();
        Servico servico = new Servico();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Agenda> agendas = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        byte op;
        do {
            System.out.println("\n--------------------------"
                    +                  "\n-- 1- Cadastrar Serviço --"
                    +                  "\n-- 2- Cadastrar Cliente --"
                    +                  "\n-- 3- Agendar           --"
                    +                  "\n-- 4- Sair              --"
                    +                  "\n--------------------------"
                    +                  "\nDigite Aqui: ");
            op = ler.nextByte();

            switch (op){
                case 1:
                    System.out.println("Digite o nome do serviço que deseja cadastrar");
                    servico.setNome(ler.next());
                    System.out.printf("Digite a descricao do serviço");
                    servico.setDescricao(ler.next());
                    System.out.printf("Digite o valor do serviço");
                    servico.setValor(ler.nextDouble());
                    if(servico.isValid(servico)){
                        servicos.add(servico);
                        System.out.println("Serviço cadastrado com Sucesso");
                    }else{
                        System.out.println("Erro, válide os dados");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente que deseja cadastrar");
                    cliente.setNome(ler.next());
                    System.out.println("Digite o email do cliente");
                    cliente.setEmail(ler.next());
                    System.out.println("Digite o endereco do cliente");
                    cliente.setEndereco(ler.next());
                    System.out.printf("Digite o telefone do cliente");
                    cliente.setTelefone(ler.next());
                    if (cliente.isValid(cliente)){
                        clientes.add(cliente);
                        System.out.println("Cliente cadastrado com sucesso");

                    }else{
                        System.out.println("erro, válide os dados");
                    }

                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:

            }
        }while(op!=6);
    }

}