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
        System.out.println("\n\n");
        System.out.println("######MENU######"
        +"\n# 1- Cadastrar Médico #"
        +"\n# 2- Listar Médico    #"
        +"\n# 3- Alterar Médico   #"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\n"
        +"\nEscolha uma opção: "
        );
        op = ler.nextByte();
        controller.validarOpcaoMenuPrincipal(op);
    }

}
