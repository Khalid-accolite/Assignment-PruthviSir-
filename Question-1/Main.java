


class SecThread implements Runnable{
    public void run(){
        System.out.println("Thread using Runnable interface");
    }
}
class FirstThread extends Thread{
    public void run(){
        for(int i=1;i<5;i++){
            try{
                Thread.sleep(1000);
                for(int j=0;j<i;j++){
                    System.out.print("@");
                }
                System.out.println();
            }catch (InterruptedException e){
                System.out.println("The exception is"+e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        FirstThread ft1 = new FirstThread();
        FirstThread ft2 = new FirstThread();
        ft1.start();       //thread created by extending Thread class
        ft2.start();
        SecThread st = new SecThread();
        Thread t = new Thread(st);
        t.start();                       //thread created by implementing Runnable class
    }
}
