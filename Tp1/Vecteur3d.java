package Tp1;

public class Vecteur3d {
double x, y, z;

public Vecteur3d(double x, double y, double z) {
this.x = x;
this.y = y;
this.z = z;
}

public void afficher(){
System.out.println("< " + x + ", " + y + ", " + z +" >");
}

public double norme(){
return Math.sqrt(x*x + y*y + z*z);
}

public static double somme(Vecteur3d v1, Vecteur3d v2){
    return v1.x + v2.x + v1.y + v2.y + v1.z + v2.z; 
}

public double scalaire(Vecteur3d v1, Vecteur3d v2){
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
}


public static void main(String[] args) {
Vecteur3d v1 = new Vecteur3d(1.0, 2.6, 3.3);
Vecteur3d v2 = new Vecteur3d(1.9, 3.2, 4.1);

System.out.println("le premier vecteur est : ");
v1.afficher();
System.out.println("le deuxieme vecteur est : ");
v2.afficher();
System.out.println("la norme du premier vecteur est : " + v1.norme());
System.out.println("la norme du deuxieme vecteur est : " + v2.norme());

System.out.println("la somme des deux vecteurs est : " + Vecteur3d.somme(v1, v2));
System.out.println("le produit scalaire des deux vecteurs est : " + v1.scalaire(v1, v2));

}

}