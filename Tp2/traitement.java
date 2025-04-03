package Tp2;

import java.io.*;

import java.util.*;

public class traitement {
    static ArrayList<String> t= new ArrayList<>();
    String chemin;
    public traitement(String chemin){
        this.chemin=chemin;
        File file= new File(chemin);
        if(!file.exists()){
           System.out.println("Le fichier n'existe pas");
    } else {
copier();
    }
}

public void copier(){
    try{
        BufferedReader bis = new BufferedReader(new FileReader(chemin));
        String line;
   while ((line =bis.readLine()) != null){
         t.add(line);
         bis.close();
    }
} catch (IOException e){
    System.out.println("Erreur lors de la lecture du fichier " + e.getMessage());
}

}
public String recherche(){
    int[] arr_count = new int[t.size()];   

    for (int i = 0; i < t.size(); i++) {  
        arr_count[i] = 0;
        for (int j = 0; j < t.size(); j++) {
            if (i != j) {
                if ((t.get(i)).equals(t.get(j))) {
                    arr_count[i]++;
                }
            }
        }
    }
    int max = 0;
    int index = 0;
    for (int i = 0; i < t.size(); i++) {  
        if (max < arr_count[i]) {
            max = arr_count[i];
            index = i;
            System.out.println(index + "      " + arr_count[i]);
        }
    }
    return t.get(index); 

}

public String miroir(String mot){
    return new StringBuilder(mot).reverse().toString();
}

public void remplacer(){
    for(int i=0; i<t.size(); i++){
        if (t.get(i).equals(recherche())){
            t.set(i, miroir(t.get(i)));
    }
}
}

public void ecrire(){
    try(BufferedWriter bos = new BufferedWriter(new FileWriter(chemin))){
        for(String line: t){
            bos.write(line);
            bos.newLine();
        }
    } catch (IOException e){
        System.out.println("Erreur lors de l'ecriture du fichier " + e.getMessage());
    }
}

public static void main(String[] args) {
    try {
        traitement t = new traitement("/Users/zizi/Documents/TpPr/Tp2/random.txt");
        System.out.println("Le mot le plus frequent est : " + t.recherche());
        t.remplacer();
        t.ecrire();
    } catch (Exception e) {
        System.out.println("Erreur lors de l'execution : " + e.getMessage());
    }
}

}