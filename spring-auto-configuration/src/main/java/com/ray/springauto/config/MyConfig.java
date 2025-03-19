package com.ray.springauto.config;

import org.springframework.context.annotation.Configuration;

import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class MyConfig {

    public static void main(String[] args) {
        // Thread thread = new Thread(() -> System.out.println("Hello World!"));
        // thread.start();
        // thread.interrupt();

        for (int i = 9; i < 10; i++) {

            System.out.println("123");

        }
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

        integerThreadLocal.set(1);
        integerThreadLocal.get();
        integerThreadLocal.remove();

        Integer i = Integer.valueOf(10);

        WeakReference<Integer> reference = new WeakReference<>(i);

        System.out.println((reference.get() == i));

        System.gc();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(reference.get());
        System.out.println(i);
    }

    public static void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> System.out.println("Hello World!"));

        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
                4,
                4,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                Thread::new,
                (runnable, executor) -> {
                    System.out.println("任务繁忙");
                }
        );

        for (int i = 0; i < 16; i++) {
            int finalI = i;
            executor1.execute(() -> System.out.println("Hello World!" + finalI));
            executor1.submit(() -> System.out.println("Hello World!" + finalI));
        }

        System.out.println("end");
        executor1.shutdown();
    }

    public static void test2() throws InterruptedException {

        // BlockingDeque

        new ArrayBlockingQueue<String>(10, false).put("1");

        new LinkedBlockingQueue<String>(10).put("1");

        new DelayQueue<>();

        new SynchronousQueue<String>();

        new PriorityBlockingQueue<Integer>(10, Comparator.comparingInt(Integer::intValue));

        new ReentrantLock();
    }

}
