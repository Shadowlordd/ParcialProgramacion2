/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaparcialn2;

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int size;

    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.anterior = aux;
        }
        size++;
    }

    public Nodo<T> getCabeza() { return cabeza; }
    public void setCabeza(Nodo<T> cabeza) { this.cabeza = cabeza; }
    public int getSize() { return size; }
    public void clear() { cabeza = null; size = 0; }
}
