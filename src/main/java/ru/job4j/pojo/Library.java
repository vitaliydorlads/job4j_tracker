package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Harry potter", 3065);
        Book book2 = new Book("Java", 550);
        Book book3 = new Book("Clean code", 500);
        Book book4 = new Book("Patterns", 655);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println(book.getName() + "-" + book.getCount());
        }
        System.out.println();
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (Book index : books) {
            System.out.println(index.getName() + "-" + index.getCount());
        }
        System.out.println();
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + "-" + book.getCount());
            }
        }
    }
}