package View;

import Controller.DispositivoController;
import Model.Dispositivo;

import java.util.ArrayList;
import java.util.Scanner;

public class DispositivoView {
    private Scanner ler = new Scanner(System.in);
    private DispositivoController controller = new DispositivoController();

    public void cadastrarDispositivo(){
        LimpaTela.limparTela();
        Dispositivo dispositivo = new Dispositivo();
        System.out.println("Cadastro de Dispositivo: ");
        System.out.println("Tipo: ");
        dispositivo.setTipo(ler.next());
        System.out.println("Marca: ");
        dispositivo.setMarca(ler.next());
        System.out.println("Modelo: " );
        dispositivo.setModelo(ler.next());
        System.out.println("Valores de referência: ");
        dispositivo.setValoresReferencia(ler.nextInt());

        System.out.println(controller.salvarDispositivo(dispositivo));
        MenuView.mostrarMenuPrincipal();
    }

    public void listarDispositivos(){
        ArrayList<Dispositivo> dipositivos = controller.listarDispositivos();
        LimpaTela.limparTela();
        if(dipositivos == null){
            System.out.println("Nenhum Dispositivo Cadastrado");
            MenuView.mostrarMenuPrincipal();
        }else{
            for (int i = 0; i< dipositivos.size(); i++){
                System.out.println("Dispositivos ");
                System.out.println("Tipo: " + dipositivos.get(i).getTipo());
                System.out.println("Marca: " + dipositivos.get(i).getMarca());
                System.out.println("Modelo: " + dipositivos.get(i).getModelo());
                System.out.println("Valor Referência: " + dipositivos.get(i).getValoresReferencia());

            }
            MenuView.mostrarMenuPrincipal();
        }
    }

    public void removerDispositivo() {
        Dispositivo disp = new Dispositivo();
        System.out.println("Digite o Modelo do dispositivo que deseja remover: ");
        disp.setModelo(ler.next());
        System.out.println(controller.removerDispositivo(disp));
        MenuView.mostrarMenuPrincipal();
    }
}
