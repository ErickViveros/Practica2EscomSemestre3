/*
EL NOMBRE DEBERÍA CAMBIARLO A arbolbst.java. Pero me quedé sin tiempo pq me cambio la hora de vencimiento profe :'v se pasa.
Viveros Sanchez Erick Enrique
Jimeno Reyes Magaly Citlali
3BM1
Ingenieria en Inteligencia Artificial
23-02-2022
*/
import java.util.*;

public class arbolBST implements IArbolNario {

    static nodo root;

    public static boolean existeNodo(int key) {
        return existeNodo(arbolBST.root, key);
    }

    private static boolean existeNodo(nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getPivote() == busqueda) {
            return true;
        } else if (busqueda < n.getPivote()) {
            return existeNodo(n.getIzq(), busqueda);
        } else {
            return existeNodo(n.getDer(), busqueda);
        }
    }

    public static nodo search(nodo root, int key) {
        if (root == null || root.pivote == key)
            return root;
        if (root.pivote < key)
            return search(root.der, key);
        return search(root.izq, key);
    }

    public void contarHojas() {
    }

    arbolBST() {
        root = null;
    }

    // This method mainly calls reccorrido()
    public void insertarElemento(int key, empleado aux) {
        root = recorrido(root, key, aux);
    }

    /*
     * A recursive function to
     * insert a new key in BST
     */
    nodo recorrido(nodo root, int key, empleado aux) {

        /*
         * If the tree is empty,
         * return a new node
         */
        if (root == null) {
            root = new nodo(key, aux);

            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.pivote)
            root.izq = recorrido(root.izq, key, aux);
        else if (key > root.pivote)
            root.der = recorrido(root.der, key, aux);
        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        recorrido(root);
    }

    // A utility function to
    // do inorder traversal of BST

    public void recorrido(nodo root) {
        if (root != null) {
            recorrido(root.izq);
            System.out.println(root.pivote);
            recorrido(root.der);
        }
    }

    static void borranNodo(int key) {
        root = deleteRec(root, key);
    }

    /*
     * A recursive function to
     * delete an existing key in BST
     */
    static nodo deleteRec(nodo root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.pivote)
            root.izq = deleteRec(root.izq, key);
        else if (key > root.pivote)
            root.der = deleteRec(root.der, key);

        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.izq == null)
                return root.der;
            else if (root.der == null)
                return root.izq;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.pivote = minValue(root.der);

            // Delete the inorder successor
            root.der = deleteRec(root.der, root.pivote);
        }

        return root;
    }

    static int minValue(nodo root) {
        int minv = root.pivote;
        while (root.izq != null) {
            minv = root.izq.pivote;
            root = root.izq;
        }
        return minv;
    }

    // Driver Code
    public static void main(String[] args) {
        arbolBST tree = new arbolBST();
        int menu = 1;
        Scanner scanf = new Scanner(System.in);
        empleado datos = new empleado();
        int key = 0;
        boolean x = false;
        int keys[] = new int[5];
        //nodo aux = new nodo();
        do {
            System.out.println("<Seleccione una opcion . . . (BST que guardaa en base a edad del empleado)>");
            System.out.println("<0. Salir del programa.>");
            System.out.println("<1. Ingresar empleado y guardarlo.>");
            System.out.println("<2. Buscar un empelado y eliminarlo.>");
            System.out.println("<3. Bucar un empleado e imprimir sus características.>");
            System.out.println("<4. Actualizar las caracteristicas del empleado, solo si existe.>");
            System.out.println("<5. Borra Arbol completo.>");
            menu = scanf.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("<Hasta luego.>");
                    break;

                case 1:
                    System.out.println("<Ingrese los datos requeridos del empleado.>");
                    System.out.println("<Edad?>");
                    key = scanf.nextInt();
                    datos.setEdad(key);
                    System.out.println("<Nombre?>");
                    scanf.nextLine();
                    datos.setNombre(scanf.nextLine());
                    System.out.println("<Numero de Seguro Social?>");
                    datos.setNumSegSocial(scanf.nextInt());
                    System.out.println("<Pais de Residencia?>");
                    scanf.nextLine();
                    datos.setPaisResidencia(scanf.nextLine());
                    System.out.println("<Salario?>");
                    datos.setSalario(scanf.nextInt());
                    tree.insertarElemento(key, datos);
                    break;

                case 2:
                    System.out.println("<Edad de empleado a eliminar?>");
                    key = scanf.nextInt();
                    borranNodo(key);
                    break;

                // ***************MultiThreading *************
                case 3:
                    System.out.println("<Edad de 5 empleados a buscar?>");
                    for (int i = 0; i <= 4; i++) {
                        scanf.nextLine();
                        keys[i] = scanf.nextInt();
                    }
                    
                    multithreading myThing1 = new multithreading(keys[0]);
                    myThing1.setRoot(root);
                    Thread myThread1 = new Thread(myThing1);
                    myThread1.start();

                    multithreading myThing2 = new multithreading(keys[1]);
                    myThing1.setRoot(root);
                    Thread myThread2 = new Thread(myThing2);
                    myThread2.start();

                    multithreading myThing3 = new multithreading(keys[2]);
                    myThing3.setRoot(root);
                    Thread myThread3 = new Thread(myThing3);
                    myThread3.start();

                    multithreading myThing4 = new multithreading(keys[3]);
                    myThing4.setRoot(root);
                    Thread myThread4 = new Thread(myThing4);
                    myThread4.start();

                    multithreading myThing5 = new multithreading(keys[4]);
                    myThing5.setRoot(root);
                    Thread myThread5 = new Thread(myThing5);
                    myThread5.start();

                    try {
                        myThread1.join();
                        myThread2.join();
                        myThread3.join();
                        myThread4.join();
                        myThread5.join();
                    } catch (Exception e) {
                    } finally {
                    }

                    break;

                case 4:
                    System.out.println("<Edad de empleado a actualizar?>");
                    key = scanf.nextInt();
                    x = existeNodo(key);
                    if (x) {
                        borranNodo(key);
                        System.out.println("<Ingrese los datos actualizados del empleado.>");
                        System.out.println("<Edad?>");
                        key = scanf.nextInt();
                        datos.setEdad(key);
                        System.out.println("<Nombre?>");
                        scanf.nextLine();
                        datos.setNombre(scanf.nextLine());
                        System.out.println("<Numero de Seguro Social?>");
                        datos.setNumSegSocial(scanf.nextInt());
                        System.out.println("<Pais de Residencia?>");
                        scanf.nextLine();
                        datos.setPaisResidencia(scanf.nextLine());
                        System.out.println("<Salario?>");
                        datos.setSalario(scanf.nextInt());
                        tree.insertarElemento(key, datos);
                    } else
                        System.out.println("<Empleado no encontrado.>");
                    break;

                case 5:
                    tree = new arbolBST();
                    break;
            }
        } while (menu != 0);
        scanf.close();
        System.out.println("Imprimiendo edades en inorden.");
        tree.inorder();
    }

    @Override
    public void recorrido() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean encontrarNodo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void borranNodo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminarArbol() {
        // TODO Auto-generated method stub

    }

    static class multithreading implements Runnable {
        private int numeroThread;
        private nodo root = new nodo();

        public multithreading(int numeroThread) {
            this.numeroThread = numeroThread;
        }

        public nodo getRoot() {
            return root;
        }

        public void setRoot(nodo root) {
            this.root = root;
        }

        public int getNumeroThread() {
            return numeroThread;
        }

        public void setNumeroThread(int numeroThread) {
            this.numeroThread = numeroThread;
        }

        public void searchM(){
            
        }

        @Override
        public void run() {
            System.out.println("El empleado buscado por edad: " + getNumeroThread());
            boolean x = existeNodo(numeroThread);
            nodo aux = new nodo();
            if (x) {
                aux = search(root, numeroThread);
                System.out.println("<Datos> Edad: " + aux.data.getEdad() + " ,Nombre: " + aux.data.getNombre()
                        + " ,Num. de Seguridad Social: " + aux.data.getNumSegSocial() + " ,Pais de Residencia: "
                        + aux.data.getPaisResidencia() + " ,Salario: " + aux.data.getSalario());
            } else
                try {
                    throw new EmployedNotFound("<Empleado de edad " + getNumeroThread() + " no encotrado>.");
                } catch (EmployedNotFound e) {
                    e.printStackTrace();
                }
            
        }

    }

}
