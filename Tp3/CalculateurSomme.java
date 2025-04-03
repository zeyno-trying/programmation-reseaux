package Tp3;

class ThreadSomme extends Thread {
    private int borneDebut, borneFin;
    private long resultatSomme;

    public ThreadSomme(int borneDebut, int borneFin) {
        this.borneDebut = borneDebut;
        this.borneFin = borneFin;
        this.resultatSomme = 0;
    }

    public void run() {
        for (int i = borneDebut; i <= borneFin; i++) {
            resultatSomme += i;
        }
    }

    public long getResultatSomme() {
        return resultatSomme;
    }
}

public class CalculateurSomme {
    public static void main(String[] args) throws InterruptedException {
        int limiteSuperieure = 1000; 
        int nombreThreads = 4;       

        ThreadSomme[] threads = new ThreadSomme[nombreThreads];
        int taillePlage = limiteSuperieure / nombreThreads;
        int debut = 1;
        int fin;
        long sommeTotale = 0;

      
        for (int i = 0; i < nombreThreads; i++) {
            fin = (i == nombreThreads - 1) ? limiteSuperieure : debut + taillePlage - 1; 
            threads[i] = new ThreadSomme(debut, fin);
            threads[i].start();
            debut = fin + 1;
        }

       
        for (int i = 0; i < nombreThreads; i++) {
            threads[i].join();
            sommeTotale += threads[i].getResultatSomme();
        }

     
        System.out.println("Somme totale de 1 à " + limiteSuperieure + " avec " + nombreThreads + " threads : " + sommeTotale);
    }
}
