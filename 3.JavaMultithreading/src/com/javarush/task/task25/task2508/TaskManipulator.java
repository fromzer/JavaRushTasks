package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread currentThread;

    @Override
    public void run() {
        while (true) {
            System.out.println(currentThread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {
        currentThread = new Thread(this, threadName);
        currentThread.start();
    }

    @Override
    public void stop() {
        currentThread.interrupt();
    }
}
