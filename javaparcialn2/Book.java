/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaparcialn2;

public class Book {
    private String title;            
    private String isbn;              
    private String author;            
    private int publicationYear;      
    private boolean available;        
    private int timesLoaned;         

   
    public Book(String title, String isbn, String author, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;        
        this.timesLoaned = 0;        
    }

    public void lend() {
        if (available) {
            available = false;
            timesLoaned++;
            System.out.println("El libro '" + title + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + title + "' no está disponible.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("El libro '" + title + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + title + "' ya estaba disponible.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getTimesLoaned() {
        return timesLoaned;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTimesLoaned(int timesLoaned) {
        this.timesLoaned = timesLoaned;
    }

    @Override
    public String toString() {
        return "Libro: " + title + " | ISBN: " + isbn + " | Autor: " + author +
               " | Año: " + publicationYear + " | Disponible: " + available +
               " | Veces prestado: " + timesLoaned;
    }
}