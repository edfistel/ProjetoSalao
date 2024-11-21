package Model;

public class Dispositivo {
    private String tipo;
    private String marca;
    private String modelo;
    private boolean status;
    private int valoresReferencia;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getValoresReferencia() {
        return valoresReferencia;
    }

    public void setValoresReferencia(int valoresReferencia) {
        this.valoresReferencia = valoresReferencia;
    }
}
