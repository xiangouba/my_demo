package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author gxx
 * @Date 2023年02月21日08时45分
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoVO2 implements Delayed {
    private Long id;
    private String name;
    private long start = System.currentTimeMillis();
    private long time ;

    /**
     * 需要实现的接口，获得延迟时间，用过期时间-当前时间
     * @param unit the time unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DemoVO2 o1 = (DemoVO2) o;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
