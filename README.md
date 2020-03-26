## springboot_mongodb
#### 高级多线程控制类  
- ThreadLocal类  
1 每个ThreadLocal只能保存一个变量副本，   
如果想要上线一个线程能够保存多个副本以上，就需要创建多个ThreadLocal。  
2 ThreadLocal内部的ThreadLocalMap键为弱引用，会有内存泄漏的风险。  
3 适用于无状态，副本变量独立后不影响业务逻辑的高并发场景。如果如果业务逻辑强依赖于副本变量，则不适合用ThreadLocal解决，需要另寻解决方案  
引入ThreadLocal的初衷是为了提供线程内的局部变量，而不是为了解决共享对象的多线程访问问题。实际上，ThreadLocal根本就不能解决共享对象的多线程访问问题

每个线程都有自己的ThreadLocalMap  ThreadLocalMap 中键值为ThreadLocal对象


- 原子类（AtomicInteger）