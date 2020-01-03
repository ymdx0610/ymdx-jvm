package com.ymdx.jvm.bytecode;

import javassist.*;

/**
 * @ClassName: GenUserClassDemo
 * @Description: javassist生成class文件
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-03 16:10
 * @Version: 1.0
 **/
public class GenUserClassDemo {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        // 创建User类
        CtClass userClass = pool.makeClass("com.ymdx.jvm.bytecode.User");
        // 添加属性
        CtField nameField = CtField.make("private String name;", userClass);
        CtField ageField = CtField.make("private Integer age;", userClass);
        userClass.addField(nameField);
        userClass.addField(ageField);
        // 添加方法
        CtMethod getNameMethod = CtMethod.make("public String getName() {\n" +
                "        return name;\n" +
                "    }", userClass);
        CtMethod setNameMethod = CtMethod.make("public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }", userClass);
        CtMethod getAgeMethod = CtMethod.make("public Integer getAge() {\n" +
                "        return age;\n" +
                "    }", userClass);
        CtMethod setAgeMethod = CtMethod.make("public void setAge(Integer age) {\n" +
                "        this.age = age;\n" +
                "    }", userClass);
        userClass.addMethod(getNameMethod);
        userClass.addMethod(setNameMethod);
        userClass.addMethod(getAgeMethod);
        userClass.addMethod(setAgeMethod);

        // 添加无参默认构造方法
        CtConstructor constructor = new CtConstructor(new CtClass[]{}, userClass);
        userClass.addConstructor(constructor);
        // 添加带参数构造方法
        // $1代表构造方法第一个参数，$2代表构造方法第二个参数，$0代表this
        CtConstructor constructor1 = new CtConstructor(new CtClass[]{pool.get("java.lang.String"), pool.get("java.lang.Integer")}, userClass);
        constructor1.setBody("{\n" +
                "        this.name = $1;\n" +
                "        this.age = $2;\n" +
                "    }");
        userClass.addConstructor(constructor1);

        // 生成class文件
        userClass.writeFile();
    }

}
