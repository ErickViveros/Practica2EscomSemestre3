/*
Viveros Sanchez Erick Enrique
3BM1
Ingenieria en Inteligencia Artificial
23-02-2022
*/

public interface IArbolNario {
    void recorrido(); //recorre el arbol.
    void insertarElemento(int key, empleado aux); //Inserta 'x' elemento.
    void borranNodo(); //Eliminar Nodo en arbol.
    boolean encontrarNodo(); //Busca Nodo en arbol.
    void eliminarArbol(); //Borra el arbol completo
    void contarHojas(); //Cuenta todas las hojas del arbol.
}