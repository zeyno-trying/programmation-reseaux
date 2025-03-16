package Tp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Lectxt2 {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String args[]) throws IOException {
String nomfich, resultFich;
int carre;
nomfich = "/Users/zizi/Documents/TpPr/Tp2/nombre.txt";
resultFich = "resultat.txt";
BufferedReader entree = new BufferedReader (new FileReader(nomfich));
BufferedWriter sortie = new BufferedWriter (new FileWriter(resultFich));
System.out.println("Nombres et carres contenus dans ce fichier");
while (true) {
String ligneLue = entree.readLine();
if (ligneLue == null)
break;
StringTokenizer tok = new StringTokenizer(ligneLue, " ");
Vector<Integer> nbrs = new Vector();
while (tok.hasMoreTokens())
nbrs.add(Integer.parseInt(tok.nextToken()));
for (int nbr : nbrs) {
carre = (int) Math.pow(nbr, 2);
if (nbrs.contains(carre)){
  String resultat = nbr + " " + carre;
  System.out.println(resultat);
sortie.write(resultat); 
sortie.newLine(); 
}

}
}
System.out.println("Les resultats sont ecrits dans " + resultFich);
entree.close();
sortie.close();
}
}
