package ru.specialist.Threads.TicTak;

public class ThreadTwo implements Runnable
{
    private Object monitor;
    //private Thread thread;

    public ThreadTwo(Object obj) {
        this.monitor = obj;
    }

    /*public Thread getThread () {
        return thread;
    }*/

    /*public ThreadTwo() {
        thread = new Thread (this);
    }*/

    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                //System.out.println(2);
                System.out.println("Tak");
                synchronized (monitor){
                    monitor.notify();
                    if (i < TicTak.num-1)
                        monitor.wait();
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void start() {
        this.run();
    }

    /*public void join() {
        this.join();
    }*/
}