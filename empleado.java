/*
Viveros Sanchez Erick Enrique
3BM1
Ingenieria en Inteligencia Artificial
23-02-2022
*/

public class empleado { 
    private String nombre;
    private int numSegSocial;
    private int edad;
    private String paisResidencia;
    private double salario;
    
    public empleado(String nombre, int numSegSocial, int edad, String paisResidencia, int salario) {
        this.nombre = nombre;
        this.numSegSocial = numSegSocial;
        this.edad = edad;
        this.paisResidencia = paisResidencia;
        this.salario = salario;
    }

    public empleado() {
    super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(int numSegSocial) {
        this.numSegSocial = numSegSocial;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double d) {
        this.salario = d;
    }
    
}
