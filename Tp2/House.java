package Tp2;

import java.io.*;
import java.util.Scanner;


public class House {
    public static String newHouse() throws IOException{
       @SuppressWarnings("resource")
       Scanner scn = new Scanner(System.in);
       System.out.println("Enter un code unique: ");
       String code = scn.nextLine();
       System.out.println("Enter l'adresse: ");
       String address = scn.nextLine();
       System.out.println("Enter le nombre de chambres: ");
       int chambres = scn.nextInt();
       System.out.println("Enter le prix en millions DA: ");
       double prix = scn.nextDouble();

       return code + " " + address + " " + chambres + " " + prix;
    }
    public static void saveHouseInByte(String house) throws IOException{
      try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/zizi/Documents/TpPr/Tp2/listHouses.dat", true))) {
        bos.write(house.getBytes());
        bos.write("\n".getBytes());
    }catch (IOException e) {
        System.out.println("Erreur lors de l'enregistrement : " + e.getMessage());
    }
      
    }

    public static void allHouseInChar() throws IOException{
        try (BufferedReader bis = new BufferedReader(new FileReader("/Users/zizi/Documents/TpPr/Tp2/listHouses.dat"))) {
        for(String line = bis.readLine(); line != null; line = bis.readLine()){
            System.out.println(line);
        }
            }
         catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + e.getMessage());
        }
    }

    public static void mergeFiles(String[] fichiers, String fichierSortie) throws IOException{
try(BufferedWriter bos= new BufferedWriter(new FileWriter(fichierSortie))){
    for(String fichier: fichiers){
        try(BufferedReader bis = new BufferedReader(new FileReader(fichier))){
            String line;
            while((line = bis.readLine()) != null){
                bos.write(line);
                bos.newLine();
            }
        }catch(IOException e){
            System.out.println("Erreur lors de la lecture du fichier " + fichier + " : " + e.getMessage());
        }
    }

}
    }

    public static void main(String[] args) {
        try {
            String h = newHouse();
            saveHouseInByte(h);
            System.out.println("la liste des maisons :");
            allHouseInChar();

String [] fichiers = {"/Users/zizi/Documents/TpPr/Tp2/listHouses.dat","/Users/zizi/Documents/TpPr/Tp2/maisons.dat", "/Users/zizi/Documents/TpPr/Tp2/immobilier.dat"};
String fichierSortie = "/Users/zizi/Documents/TpPr/Tp2/houses.dat";
mergeFiles(fichiers, fichierSortie);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'execution : " + e.getMessage());
        }

    }
}

