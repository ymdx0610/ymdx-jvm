package com.ymdx.jvm.param.config;

/**
 * @ClassName: Demo01
 * @Description: 堆内存大小配置示例
 *
 * -Xmx20m -Xms5m
 * 说明：堆最大内存为20M，堆初始化内存为5M
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-02 14:48
 * @Version: 1.0
 **/
public class Demo01 {

    public static void main(String[] args) {
        // 默认：
        //最大内存：3641M
        //已使用内存：245M
        //可用内存：242M
        System.out.println("最大内存：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("已使用内存：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println("可用内存：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");

        // 配置：-Xmx20m -Xms5m
        //最大内存：18M
        //已使用内存：5M
        //可用内存：4M

        // 如果试图分配20m空间给数组tmp，如：byte[] tmp = new byte[20 * 1024 * 1024];
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }

}
