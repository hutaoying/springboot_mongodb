## springboot_mongodb
线程中断详解：  
https://blog.csdn.net/xinxiaoyong100440105/article/details/80931705
#### 高级多线程控制类  
- ThreadLocal类  
1 每个ThreadLocal只能保存一个变量副本，   
如果想要上线一个线程能够保存多个副本以上，就需要创建多个ThreadLocal。  
2 ThreadLocal内部的ThreadLocalMap键为弱引用，会有内存泄漏的风险。  
3 适用于无状态，副本变量独立后不影响业务逻辑的高并发场景。如果如果业务逻辑强依赖于副本变量，则不适合用ThreadLocal解决，需要另寻解决方案  
引入ThreadLocal的初衷是为了提供线程内的局部变量，而不是为了解决共享对象的多线程访问问题。实际上，ThreadLocal根本就不能解决共享对象的多线程访问问题

每个线程都有自己的ThreadLocalMap  ThreadLocalMap 中键值为ThreadLocal对象  https://www.jianshu.com/p/09ceb962894d
```
//         lock2.lockInterruptibly(); 死锁可响应中断
           lock2.lock();
```

- 原子类（AtomicInteger）
- Lock
lock 比synchronized 更灵活
ReentrantLock　　　　
可重入的意义在于持有锁的线程可以继续持有，并且要释放对等的次数后才真正释放该锁
- ReentrantReadWriteLock  可重入读写锁（读写锁的一个实现）　
```
   ReentrantReadWriteLock lock = new ReentrantReadWriteLock()
　　ReadLock r = lock.readLock();
　　WriteLock w = lock.writeLock();
```
- 容器类
BlockQueue
常见阻塞队列
ArrayListBlockingQueue
LinkedListBlockingQueue
DelayQueue
SynchronousQueue
ConcurrentHashMap   
- 管理类
```
ThreadPoolExecutor

```
