package Controller;

import Model.Dispositivo;

import java.util.ArrayList;

public class DispositivoController {
    private static ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public String salvarDispositivo(Dispositivo disp) {
        if(pesquisarDispositivoPorTipo(disp.getTipo()) == null){
            dispositivos.add(disp);
            return "Dispositivo Cadastrado com sucesso";
        }else{
            return "Dispositivo ja cadastrado";
        }
    }

    public static Dispositivo pesquisarDispositivoPorTipo(String tipo){
        if(dispositivos.isEmpty() ){
            return null;
        }else{
            for(int i =0; i < dispositivos.size(); i++){
                if(dispositivos.get(i).getTipo().equalsIgnoreCase(tipo)){
                    return dispositivos.get(i);
                }
            }
        }
        return null;
    }
    public ArrayList<Dispositivo> listarDispositivos(){
        if(dispositivos.isEmpty()){
            return null;
        }else{
            return dispositivos;
        }
    }

    public String removerDispositivo(Dispositivo disp) {
        if(dispositivos.isEmpty() ){
            return "Nenhum dispositivo cadastrado";
        }else{
            for(int i =0; i < dispositivos.size(); i++){
                if(dispositivos.get(i).getModelo().equalsIgnoreCase(disp.getModelo())){
                    dispositivos.remove(i);
                    return "Dispositivo removido com sucesso";
                }
            }
        }
        return "Erro ao remover Dispositivo";
    }
}
