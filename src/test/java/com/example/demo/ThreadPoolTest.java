package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class ThreadPoolTest {
    private ThreadPoolExecutor fastTriggerPool = null;
    private ThreadPoolExecutor slowTriggerPool = null;

    public String ThreadTest(String str){
        System.out.println("输入的参数为：" + str);
        return str;
    }

    @Test
    public void ThreadPoolExecutorTest() throws ExecutionException, InterruptedException {
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
        System.out.println("第一个任务");
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                ThreadTest("线程池执行方法的测试");
            }
        };
        Future<?> a  = slowTriggerPool.submit(worker);

        System.out.println(a.get());

    }

    public void test(){
        List<String> a = new ArrayList();
        a.add("123_456_abc");
        a.add("456_abc_123");
        // 判定 "123_456_abc" 和 "123_456_abc" 相同

        for (int i = 0; i < a.size(); i++) {
            String  str = a.get(i);
        }
    }

}
