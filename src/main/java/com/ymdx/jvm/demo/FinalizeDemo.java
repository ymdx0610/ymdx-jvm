package com.ymdx.jvm.demo;

/**
 * @ClassName: FinalizeDemo
 * @Description: finalize示例
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2019-12-31 17:14
 * @Version: 1.0
 **/
public class FinalizeDemo {

    public static void main(String[] args) {
        FinalizeDemo obj1 = new FinalizeDemo();
        // 设置obj1为不可达对象，加快GC惠州
        obj1 = null;
        // 提示GC可以回收，但不保证GC会立即回收
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("正在执行垃圾回收前的准备工作...");
    }

}
