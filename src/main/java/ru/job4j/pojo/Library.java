package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Гарри Потер", 500);
        Book book2 = new Book("Clean code", 200);
        Book book3 = new Book("Clean code", 200);
        Book book4 = new Book("One", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getNumberOfPages());
        }
        System.out.println("=============");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getNumberOfPages());
        }
        System.out.println("=============");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " " +  book.getNumberOfPages());
            }
        }
    }
}

