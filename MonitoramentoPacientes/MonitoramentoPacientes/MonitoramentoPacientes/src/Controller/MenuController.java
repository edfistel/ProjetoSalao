package Controller;

import Model.Medico;
import View.MedicoView;
import View.MenuView;

import java.util.ArrayList;

public class MenuController {

    private MedicoView medicoView = new MedicoView();
    public void validarOpcaoMenuPrincipal(byte op) {
        switch (op){
            case 1:
                medicoView.cadastrarMedico();
                break;
            case 2:
                medicoView.mostrarMedico();
                break;
            case 3:
                medicoView.alterarMedico();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:

        }
    }



}
