package View;
import Controller.MenuController;
import java.util.Scanner;
import static View.LimpaTela.limparTela;

public class MenuView {
    private static Scanner ler = new Scanner(System.in);
    private static MenuController controller;
    private static byte op;

    // Agora, o MenuController é passado no construtor
    public MenuView(MenuController controller) {
        this.controller = controller;
    }
    public static void mostrarMenuPrincipal(){
        System.out.println("\n");
        System.out.println("###########MENU###########"
        +"\n# 1- Cadastrar Médico    #"
        +"\n# 2- Listar Médico       #"
        +"\n# 3- Alterar Médico      #"
        +"\n# 4- Cadastrar Paciente  #"
        +"\n# 5- Listar Paciente     #"
        +"\n# 6- Consultar Hist Pac  #"
        +"\n# 7- Alterar Dados Pac   #"
        +"\n# 8- Agendar Consulta    #"
        +"\n# 9- Ver Consultas       #"
        +"\n# 10-Add Prescrição      #"
        +"\n# 11-Add Diagnóstico     #"
        +"\n# 12-Add Medicamento     #"
        +"\n# 13-Listar Medicamento  #"
        +"\n# 14-Cadastrar Disp      #"
        +"\n# 15-Listar Disp         #"
        +"\n# 16-Remover Disp        #"
        +"\n# 17-Add Monitoramento   #"
        +"\n# 18-Listar Monitoramento#"
        +"\n# 19-Gerar Alertas       #"
        +"\n# 20-Listar Alertas      #"
        +"\n# 21-Remover Alertas     #"
        +"\n# 22-Alterar Alertas     #"
        +"\n# 23-Sair                #"
        +"\n##########################"
        +"\nEscolha uma opção: "
        );
        op = ler.nextByte();
        controller.validarOpcaoMenuPrincipal(op);
    }
    public static void mensagem(String texto){
        System.out.println(texto);
    }

}
