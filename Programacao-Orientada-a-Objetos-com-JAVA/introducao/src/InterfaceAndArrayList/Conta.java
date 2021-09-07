package InterfaceAndArrayList;

public class Conta implements Comparable {

    private int num;
    private double saldo;

    public Conta(int num, double saldo) {
        this.num = num;
        this.saldo = saldo;
    }

    @Override
    public int compareTo(Object o) {

        Conta c = (Conta) o;
        int result = 0;

        if(this.getSaldo() > c.getSaldo()){
            result = 1;
        }

        if(this.getSaldo() < c.getSaldo()){
            result =  -1;
        }

        return result;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
