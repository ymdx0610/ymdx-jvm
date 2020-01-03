package com.ymdx.jvm.bytecode;

import java.lang.reflect.Method;

/**
 * @ClassName: ReflectionInvokeMethodDemo
 * @Description: 反射调用方式示例
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-03 17:44
 * @Version: 1.0
 **/
public class ReflectionInvokeMethodDemo {

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("com.ymdx.jvm.bytecode.ReflectionInvokeMethodDemo");
            Object obj = cls.newInstance();
            Method method = cls.getDeclaredMethod("sum", int.class, int.class);
            method.invoke(obj, 1, 2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sum(int a, int b) {
        System.out.println(a + b);
    }
}
