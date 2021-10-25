package models;

public class Computador {
    private int ram;
    private int hd;
    private static int contador;

    public Computador(int ram, int hd) {
        this.ram = ram;
        this.hd = hd;
        this.contador++;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public static int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
