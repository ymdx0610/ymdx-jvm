package com.ymdx.jvm.param.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OOMDemo
 * @Description: Java堆溢出示例
 *
 * -Xms1m -Xms10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-02 16:51
 * @Version: 1.0
 **/
public class OOMDemo {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            Byte[] bytes = new Byte[1 * 1024 * 1024];
            list.add(bytes);
        }
        System.out.println("添加成功...");
    }

}
