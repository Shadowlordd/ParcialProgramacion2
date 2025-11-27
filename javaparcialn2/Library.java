/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaparcialn2;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final ListaEnlazada<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ListaEnlazada<>();
    }

    public void addBook(Book book) {
        books.insertarFinal(book);
        System.out.println("Libro agregado: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        Nodo<Book> actual = books.getCabeza();
        Nodo<Book> anterior = null;

        while (actual != null) {
            if (actual.dato.getIsbn().equalsIgnoreCase(isbn)) {
                if (anterior == null) {
                    books.setCabeza(actual.siguiente);
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = anterior;
                }
                System.out.println("Libro eliminado: " + actual.dato.getTitle());
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        System.out.println("No se encontró libro con ISBN: " + isbn);
    }

    public Book findBookByIsbn(String isbn) {
        Nodo<Book> actual = books.getCabeza();
        while (actual != null) {
            if (actual.dato.getIsbn().equalsIgnoreCase(isbn)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> resultados = new ArrayList<>();
        Nodo<Book> actual = books.getCabeza();
        while (actual != null) {
            if (actual.dato.getTitle().toLowerCase().contains(title.toLowerCase())) {
                resultados.add(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> resultados = new ArrayList<>();
        Nodo<Book> actual = books.getCabeza();
        while (actual != null) {
            if (actual.dato.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                resultados.add(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public List<Book> getAvailableBooks() {
        List<Book> disponibles = new ArrayList<>();
        Nodo<Book> actual = books.getCabeza();
        while (actual != null) {
            if (actual.dato.isAvailable()) {
                disponibles.add(actual.dato);
            }
            actual = actual.siguiente;
        }
        return disponibles;
    }

    public List<Book> getLoanedBooks() {
        List<Book> prestados = new ArrayList<>();
        Nodo<Book> actual = books.getCabeza();
        while (actual != null) {
            if (!actual.dato.isAvailable()) {
                prestados.add(actual.dato);
            }
            actual = actual.siguiente;
        }
        return prestados;
    }

    public void getStatistics() {
        int total = 0, disponibles = 0, prestados = 0;
        Nodo<Book> actual = books.getCabeza();

        while (actual != null) {
            total++;
            if (actual.dato.isAvailable()) {
                disponibles++;
            } else {
                prestados++;
            }
            actual = actual.siguiente;
        }

        System.out.println("Estadísticas de la biblioteca '" + name + "':");
        System.out.println("Total de libros: " + total);
        System.out.println("Disponibles: " + disponibles);
        System.out.println("Prestados: " + prestados);
    }
}
