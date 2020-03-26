package com.one.springboot_mongodb.lock1;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多生产者 多消费者  实现方式2 await()/signal()
 * 通知对应的线程
 */
public class ProCon {
    // 仓库容量
    private final int MAX_SIZE = 10;
    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    // 仓库满的条件变量
    private final Condition full = lock.newCondition();
    // 仓库空的条件变量
    private final Condition empty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】仓库已满");
                try {
                    full.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
            empty.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void consume() {
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】仓库为空");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + list.size());
            full.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
