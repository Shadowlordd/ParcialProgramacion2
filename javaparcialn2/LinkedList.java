/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaparcialn2;


public class LinkedList<T> {
    private Node<T> head;  
    private int size;       

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
            nuevo.prev = aux;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<T> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public boolean remove(T data) {
        Node<T> aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) {
                if (aux.prev != null) {
                    aux.prev.next = aux.next;
                } else {
                    head = aux.next; // era el primero
                }
                if (aux.next != null) {
                    aux.next.prev = aux.prev;
                }
                size--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public boolean contains(T data) {
        Node<T> aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
