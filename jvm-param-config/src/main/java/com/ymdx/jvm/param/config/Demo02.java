package com.ymdx.jvm.param.config;

/**
 * @ClassName: Demo02
 * @Description: 设置新生代比例参数示例
 *
 * -Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 说明：堆初始化内存为20M，堆最大内存为20M，堆新生代最大内存为1M，新生代eden区与from／to区内存占比为2:1，详细打印GC日志，使用窜行垃圾收集器
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-02 15:01
 * @Version: 1.0
 **/
public class Demo02 {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }

}
