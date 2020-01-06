package com.ymdx.jvm.classloader;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @ClassName: Test
 * @Description: 热部署示例
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-06 14:28
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {
        try {
            System.out.println("热部署前...");
            loadUserAndInvokeDescMethod();

            System.out.println("热部署后...");
            Path sourcePath = Paths.get("jvm-classloader/test/User.class");
            Path targetPath = Paths.get("jvm-classloader/target/classes/com/ymdx/jvm/classloader/User.class");
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            loadUserAndInvokeDescMethod();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadUserAndInvokeDescMethod() throws Exception{
        MyClassLoader mcl = new MyClassLoader();
        Class<?> cls = mcl.findClass("com.ymdx.jvm.classloader.User");
        Object obj = cls.newInstance();
        Method method = cls.getDeclaredMethod("desc");
        method.invoke(obj);
    }

}
