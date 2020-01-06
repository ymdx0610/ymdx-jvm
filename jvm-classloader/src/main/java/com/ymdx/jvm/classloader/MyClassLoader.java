package com.ymdx.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: MyClassLoader
 * @Description: 自定义类加载器
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-06 14:17
 * @Version: 1.0
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream is = this.getClass().getResourceAsStream(fileName);
        try {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            // 将byte字节流解析成jvm能够识别的Class对象
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }

}
