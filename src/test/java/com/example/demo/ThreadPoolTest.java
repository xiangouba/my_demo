package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ThreadPoolTest {
    private ThreadPoolExecutor fastTriggerPool = null;
    private ThreadPoolExecutor slowTriggerPool = null;

    @Test
    public void ThreadPoolExecutorTest(){
        //建立一个线程池
        fastTriggerPool = new ThreadPoolExecutor(10,200,60L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(1000));

        //建立一个线程池
        slowTriggerPool = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2000),
                new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"慢速线程池建立完成" + r.hashCode());
            }
        });
        slowTriggerPool.execute(() -> {
            System.out.println("2");
        });
        fastTriggerPool.execute(() -> {
            System.out.println("1");
        });


    }

}
