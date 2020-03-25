package com.one.springboot_mongodb.test;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeTest {
    private static Unsafe unsafe;

    static {
        try {
// 通过反射获取rt.jar下的Unsafe类
// Unsafe虽然有静态的getUnsafe()方法，但是如果你尝试调用Unsafe.getUnsafe()，会得到一个SecutiryException。这个类只有被JDK信任的类实例化。
// Unsafe类的构造函数是私有的；
//这个类是属于sun.* API中的类，并且它不是J2SE中真正的一部份，因此你可能找不到任何的官方文档
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println("Get Unsafe instance occur error" + e);
        }
    }
    public static void main(String[] args) throws Exception {
        Class<Target> clazz = Target.class;
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fieldName:fieldOffset");
        for (Field f : fields) {
// 获取属性偏移量，可以通过这个偏移量给属性设置
            System.out.println(f.getName() + ":" + unsafe.objectFieldOffset(f));
        }
        Target target = new Target();
        Field intFiled = clazz.getDeclaredField("intParam");
        int a = (Integer) intFiled.get(target);
        System.out.println("原始值是:" + a);
// intParam的字段偏移是12 原始值是3 我们要改为10
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
        int b = (Integer) intFiled.get(target);
        System.out.println("改变之后的值是:" + b);
        System.out.println(intFiled.getName() + ":" + unsafe.objectFieldOffset(intFiled));

// 这个时候已经改为10了,所以会返回false
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 11));
        System.out.println(unsafe.compareAndSwapObject(target, 24, null, "5"));
        int c = (Integer) intFiled.get(target);
        System.out.println("改变之后的值是:" + c);
        System.out.println(target);
    }




}
class Target {
    int intParam = 3;
    long longParam;
    String strParam;
    String strParam2;
}