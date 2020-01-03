package com.ymdx.jvm.bytecode;

import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @ClassName: ModifyUserClassDemo
 * @Description: Javassist动态为类添加方法并执行示例
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-03 17:42
 * @Version: 1.0
 **/
public class ModifyUserClassDemo {

    public static void main(String[] args) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass userClass = pool.get("com.ymdx.jvm.bytecode.User");

            CtMethod sumMethod = new CtMethod(CtClass.voidType, "sum", new CtClass[]{CtClass.intType, CtClass.intType}, userClass);
            sumMethod.setBody("{}");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
