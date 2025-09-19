public class Main{
    public static void main(String[] args){

        Thread1 ob1 = new Thread1();
        Thread2 ob2 = new Thread2();
        ob1.start();
        ob2.start();
    }
    static class Thread1 extends Thread{
        public void run(){
            for (int i = 0; i >= 0; i++){
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
        }
    }
    static class Thread2 extends Thread{
        public void run(){
            for (int i = 10; i >= 0; i++){
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
        }
    }
}