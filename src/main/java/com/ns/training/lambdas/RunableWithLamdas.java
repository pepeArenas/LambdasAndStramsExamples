package com.ns.training.lambdas;

public class RunableWithLamdas {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello world from Thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        Runnable runnableWithLambdas =
                () -> {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Hello world from Thread with lambdas[" + Thread.currentThread().getName() + "]");
                    }
                };

        Thread threadWithLambdas = new Thread(runnableWithLambdas);
        threadWithLambdas.start();
        threadWithLambdas.join();
    }
}
