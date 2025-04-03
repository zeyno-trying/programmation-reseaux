package Tp3;

class Buffer {
    private char[] buffer;
    private int size, count = 0, in = 0, out = 0;

    public Buffer(int size) {
        this.size = size;
        this.buffer = new char[size];
    }

    public synchronized void put(char c) throws InterruptedException {
        while (count == size) {
            wait(); 
        }
        buffer[in] = c;
        in = (in + 1) % size;
        count++;
        System.out.println(Thread.currentThread().getName() + " a produit : " + c);
        notifyAll(); 
    }

    public synchronized char get() throws InterruptedException {
        while (count == 0) {
            wait(); 
        }
        char c = buffer[out];
        out = (out + 1) % size;
        count--;
        System.out.println(Thread.currentThread().getName() + " a consommé : " + c);
        notifyAll(); 
        return c;
    }
}

class Producteur extends Thread {
    private Buffer buffer;

    public Producteur(Buffer b) {
        this.buffer = b;
        this.setName("Producteur");
    }

    public void run() {
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                buffer.put(c);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " interrompu.");
        }
    }
}

class Consommateur extends Thread {
    private Buffer buffer;

    public Consommateur(Buffer b) {
        this.buffer = b;
        this.setName("Consommateur");
    }

    public void run() {
        try {
            for (int i = 0; i < 26; i++) { 
                buffer.get();
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " interrompu.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); 
        Producteur producteur = new Producteur(buffer);
        Consommateur consommateur = new Consommateur(buffer);

        producteur.start();
        consommateur.start();
    }
}

