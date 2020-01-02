package com.ymdx.jvm.param.config;

/**
 * @ClassName: StackOverflowDemo
 * @Description: 虚拟机栈溢出
 *
 * -Xss5m
 * 说明：设置线程最大调用深度
 *
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-02 17:12
 * @Version: 1.0
 **/
public class StackOverflowDemo {

    private static int count;

    public static void count(){
        try {
            count ++ ;
            count();
        }catch (Throwable e){
            // 默认，最大深度：11635
            // 配置-Xss5m，最大深度：239783
            System.out.println("最大深度：" + count);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        count();
    }

}
