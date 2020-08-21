package Modelo;

public class Producto {
    int id;
    String prod;
    double pre;
    int cant;

    public Producto() {
    }

    public Producto(int id, String prod, double pre, int cant) {
        this.id = id;
        this.prod = prod;
        this.pre = pre;
        this.cant = cant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }


    
}
