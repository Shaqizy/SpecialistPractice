package ru.specialist.Threads.TicTak;

public class ThreadOne extends Thread {

    private Object monitor;

    public ThreadOne(Object obj) {
        this.monitor = obj;
    }

    public void run () {
        try
        {
            for (int i = 0; i < TicTak.num; i++) {
                //System.out.print(1+" - ");
                System.out.print("Tik" + " - ");
                synchronized (monitor){
                    monitor.notify();
                    if (i < TicTak.num-1)
                        monitor.wait();
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}