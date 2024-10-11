import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Agenda agenda = new Agenda();
        Servico servico = new Servico();
        Scanner ler = new Scanner(System.in);
        byte op;
        do {
            Cliente cliente1 = new Cliente();
            Agenda agenda1 = new Agenda();
            Servico servico1 = new Servico();
            System.out.println("\n--------------------------"
                    +                  "\n-- 1- Cadastrar Serviço --"
                    +                  "\n-- 2- Cadastrar Cliente --"
                    +                  "\n-- 3- Agendar           --"
                    +                  "\n-- 4- Listar Servicos   --"
                    +                  "\n-- 5- Listar Clientes   --"
                    +                  "\n-- 6- Listar Agendas    --"
                    +                  "\n-- 7- Sair              --"
                    +                  "\n--------------------------"
                    +                  "\nDigite Aqui: ");
            op = ler.nextByte();

            switch (op){
                case 1:
                    System.out.println("Digite o nome do serviço que deseja cadastrar");
                    servico1.setNome(ler.next());
                    System.out.println("Digite a descricao do serviço");
                    servico1.setDescricao(ler.next());
                    System.out.println("Digite o valor do serviço");
                    servico1.setValor(ler.nextDouble());
                    if(servico.isValid(servico1)){
                        servico.getServicos().add(servico1);
                        System.out.println("Serviço cadastrado com Sucesso");
                    }else{
                        System.out.println("Erro, válide os dados");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente que deseja cadastrar");
                    cliente1.setNome(ler.next());
                    System.out.println("Digite o email do cliente");
                    cliente1.setEmail(ler.next());
                    System.out.println("Digite o endereco do cliente");
                    cliente1.setEndereco(ler.next());
                    System.out.println("Digite o telefone do cliente");
                    cliente1.setTelefone(ler.next());
                    if (cliente.isValid(cliente1)){
                        cliente.getClientes().add(cliente1);
                        System.out.println("Cliente cadastrado com sucesso");

                    }else{
                        System.out.println("erro, válide os dados");
                    }

                    break;

                case 3:
                    System.out.println("Digite o Servico que deseja agendar:");
                    servico1.setNome(ler.next());
                    Servico serv = servico.pesquisarServicoPorNome(servico1);
                    if(serv != null){
                        System.out.println("Servico encontrado:");
                        System.out.println("Nome: " + serv.getNome());
                        System.out.println("Descrição: " + serv.getDescricao());
                        System.out.println("Valor: " + serv.getValor());
                        System.out.println("\n Digite a data(xx/xx/xxxx) que deseja  agendar: ");
                        agenda1.setData(ler.next());
                        if(agenda.validarDisponibilidade(agenda1.getData(), serv)){
                            System.out.println("Digite o nome do Cliente que deseja agendar: ");
                            cliente1.setNome(ler.next());
                            Cliente cli = cliente.validarClientePorNome(cliente1.getNome());
                            if(cli !=null ){
                                agenda1.setServico(serv.getNome());
                                agenda1.setNomeCliente(cli.getNome());
                                agenda.getAgendas().add(agenda1);
                                System.out.println("Agendamento cadastrado");
                            }else{
                                System.out.println("Cliente não encontrado");
                            }
                        }else{
                            System.out.println("Data não disponivel");
                        }

                    }else{
                        System.out.println("Serviço não cadastrado.");
                    }
                    break;

                case 4:
                    servico.listarServicos();
                    break;
                case 5:
                    cliente.listarClientes();
                    break;
                case 6:
                    agenda.listarAgendamentos();
                    break;
                case 7:
                    System.out.println("Programa encerrado.");
                    break;
                default:

            }
        }while(op!=7);
    }

}