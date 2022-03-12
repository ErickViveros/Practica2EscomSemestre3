/*
Viveros Sanchez Erick Enrique
3BM1
Ingenieria en Inteligencia Artificial
23-02-2022
*/

public class nodo {
    public int pivote;
    empleado data;
    nodo izq, der;

    public nodo(int pivote, empleado aux) {
        this.pivote = pivote;
        this.data = aux;
        izq = der = null;
    }

    public nodo() {
        super();
        }
    
    public int getPivote() {
        return pivote;
    }
    public void setPivote(int pivote) {
        this.pivote = pivote;
    }
    public nodo getIzq() {
        return izq;
    }
    public void setIzq(nodo izq) {
        this.izq = izq;
    }
    public nodo getDer() {
        return der;
    }
    public void setDer(nodo der) {
        this.der = der;
    }

    
}
