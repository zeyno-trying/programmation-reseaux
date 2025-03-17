package Tp2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Book implements Serializable {
    public String title, author;
    public int year;

    ArrayList<Book> books= new ArrayList<>();
    public Book(String title, String author, int year){
        this.title= title;
        this.author= author;
        this.year= year;
    }

    public void ajouterBook(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter le titre: "); 
        String title = scn.nextLine();
        System.out.println("Enter l'auteur: ");
        String author = scn.nextLine();
        System.out.println("Enter l'annee: ");
        int year = scn.nextInt();
        books.add(new Book(title, author, year));
    }
    public void saveBooks(ArrayList<Book> books, File file) throws FileNotFoundException, IOException{
ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
oos.writeObject(books);
oos.close();
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Book> loadBooks(File file) throws ClassNotFoundException, IOException{
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
    return (ArrayList<Book>) ois.readObject();

}
    }

    public static void main(String[] args) {
        Book book= new Book("Java", "James Gosling", 1995);
        book.ajouterBook();
        File file= new File("/Users/zizi/Documents/TpPr/Tp2/books.dat");
        try {
            book.saveBooks(book.books, file);
            ArrayList<Book> books= book.loadBooks(file);
            for(Book b: books){
                System.out.println(b.title + " " + b.author + " " + b.year);
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Erreur lors de la lecture ou l'ecriture du fichier: " + e.getMessage());
        }
    }
}
