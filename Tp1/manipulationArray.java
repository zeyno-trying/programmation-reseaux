package Tp1;

import java.util.ArrayList;

public class manipulationArray {
public static void main(String[] args) {
    ArrayList<String> Langages= new ArrayList<String>();
    Langages.add("Java");
    Langages.add("Python");
    Langages.add("C++");
    Langages.add("PHP");

    System.out.println("La collection des langages: " + Langages);

    for(int i=0; i<Langages.size(); i++){
        System.out.println(Langages.get(i));
    }
    
    Langages.add(0, "Pascal");
    System.out.println("Ajout de Pascal a la tete de liste: " +Langages);
    System.out.println("Le troisieme element de la liste: " +Langages.get(2));
    Langages.set(2, "COBOL");
    System.out.println("Mise a jour de le troisieme element : " +Langages);
    Langages.remove(2);
    System.out.println("Suppression de le troisieme element " +Langages);
}
    
}