/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaparcialn2;

public class Javaparcialn2 {
    public static void main(String[] args) {
        Library biblioteca = new Library("Biblioteca Central");

        Book libro1 = new Book("Cien años de soledad", "ISBN001", "Gabriel García Márquez", 1967);
        Book libro2 = new Book("El Aleph", "ISBN002", "Jorge Luis Borges", 1949);

        biblioteca.addBook(libro1);
        biblioteca.addBook(libro2);

        // Estado inicial
        biblioteca.getStatistics();

        // Préstamo y devolución
        libro1.lend();
        libro1.returnBook();

        // Búsquedas
        System.out.println("Buscar por ISBN: " + biblioteca.findBookByIsbn("ISBN001"));
        System.out.println("Buscar por título: " + biblioteca.findBooksByTitle("Cien años"));
        System.out.println("Buscar por autor: " + biblioteca.findBooksByAuthor("Borges"));

        // Consultas
        System.out.println("Libros disponibles: " + biblioteca.getAvailableBooks());
        System.out.println("Libros prestados: " + biblioteca.getLoanedBooks());

        // Eliminar libro
        biblioteca.removeBook("ISBN002");

        // Estado final
        biblioteca.getStatistics();
    }
}


