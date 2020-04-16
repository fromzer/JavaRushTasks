package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;
    private Thread.State threadState;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        threadState = thread.getState();
    }

    @Override
    public void run() {
        System.out.println(threadState);

        while (true) {
            if (thread.getState() != threadState) {
                threadState = thread.getState();
                System.out.println(threadState);
            } else if (threadState == State.TERMINATED) {
                break;
            }
        }
    }
}
