package com.ymdx.jvm.bytecode;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * @ClassName: AddAndInvokeMethodToUserDemo
 * @Description: Javassist动态为类添加方法并执行示例
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-03 17:42
 * @Version: 1.0
 **/
public class AddAndInvokeMethodToUserDemo {

    public static void main(String[] args) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass userClass = pool.get("com.ymdx.jvm.bytecode.User");

            // 添加方法
            CtMethod sumMethod = new CtMethod(CtClass.voidType, "sum", new CtClass[]{CtClass.intType, CtClass.intType}, userClass);
            sumMethod.setBody("{System.out.println($1 + $2);}");
            userClass.addMethod(sumMethod);
            userClass.writeFile();

            // 动态调用
            Class clazz = userClass.toClass();
            Object obj = clazz.newInstance();
            Method sum = clazz.getDeclaredMethod("sum", int.class, int.class);
            sum.invoke(obj, 1, 3);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
