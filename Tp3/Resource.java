package Tp3;

public class Resource {
    private StringBuilder str; 

    public Resource() {
        str = new StringBuilder();
    }

    public synchronized void addChar(int c) { 
        str.append((char)c);
    }	

    public synchronized void addNum(int n) {  
        str.append(n);
    }

    public synchronized String getStr() {
        return str.toString();
    }
}

class Thd1 extends Thread {
    private Resource r1; 

    public Thd1(Resource r) { 
        r1 = r;
    }

    public void run() {
        for (int i = 'A'; i <= 'Z'; i++) {  
            r1.addChar(i);
        }
    }
}

class Thd2 extends Thread {
    private Resource r1; 

    public Thd2(Resource r) { 
        r1 = r;
    }

    public void run() {
        for (int i = 0; i < 26; i++) {  
            r1.addNum(i);
        }
    }
}
