package DesignPatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static volatile Singleton singletonObj = null;
    private Singleton() {}

    public static Singleton getInstance() {
        if (singletonObj == null) {
            System.out.println("Singleton obj doesn't exist");
            synchronized (Singleton.class) {
                if (singletonObj == null) {
                    System.out.println("Singleton obj still doesn't exist");
                    singletonObj = new Singleton();
                }
            }
        }
        else{
            System.out.println("Singleton obj already exists");
        }
        return singletonObj;
    }

    public void showMessage() {
        System.out.println("Hello from singleton: " + Singleton.getInstance());
    }

    public static void main(String[] args) {
        // testUsingThreads();

        testUsingThreadPool();
    }

    private static void testUsingThreads() {
        System.out.println("Test Using 2 Threads");
        Thread thread1 = new Thread(new SingletonRunnable("thread1"));
        Thread thread2 = new Thread(new SingletonRunnable("thread2"));

        thread1.start();
        thread2.start();
    }

    private static void testUsingThreadPool() {
        System.out.println("Test Using Threadpool");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            executorService.submit(new SingletonRunnable("thread"+i));
        }

        executorService.shutdown();
    }
}

class SingletonRunnable implements Runnable {
    String name;
    public SingletonRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Thread: " + name);
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
        System.out.println("Instance Hashcode: " + singleton.hashCode());
    }
}


