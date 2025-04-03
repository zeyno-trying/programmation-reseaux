package Tp3;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();

        Thd1 t1 = new Thd1(resource);
        Thd2 t2 = new Thd2(resource);

        t1.start();
        t2.start();

        t1.join(); 
        t2.join();

        System.out.println("Contenu final de Resource : " + resource.getStr());
    }
}

