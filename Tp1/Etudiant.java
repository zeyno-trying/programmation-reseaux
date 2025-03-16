package Tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant {
    public int trouveIndice(String nom, String[] tNoms){
        for (int i = 0; i < tNoms.length; i++) {
            if (tNoms[i].equals(nom)) {
                return i;
            }
        }
        return -1;
    }

    public double trouveNote(String nom, String[] tNoms, double[] tNotes){
        int indice= trouveIndice(nom, tNoms);
        for(int i=0; i<tNotes.length; i++){
            if (indice==i) {
                return tNotes[i];
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant();
        String[] tNoms = {"zeyno", "celina", "nour", "chanez", "samar"};
        double[] tNotes = {18.5, 17.0, 19.0, 20.0, 17.5};
        @SuppressWarnings("resource")
        Scanner name= new Scanner(System.in);
        System.out.println("Donner un nom d'une etudiante : ");
        String nom= name.nextLine();
        System.out.println("la note de l'etudiante "+nom+" est : "+ etudiant.trouveNote(nom, tNoms, tNotes));
    }

}

