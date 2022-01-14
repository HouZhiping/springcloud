package com.hou.gy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class MemoryRecycleTest {

    @Test
    public void testMemoryRecycle() throws InterruptedException {

        List list = new ArrayList();

        //指定要生产的对象大小为512m
        int count = 125;

        //新建一条线程，负责生产对象
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
//                    System.out.println(String.format("第%s次生产%s大小的对象", i, count));
                    log.info("第{}次生产{}大小的对象", i, count);
                    addObject2List(list, count);
                    //休眠40秒
                    Thread.sleep(i * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "create object").start();

        //新建一条线程，负责清理list，回收jvm内存
        new Thread(() -> {
            log.info("回收线程启动");
            while (true){
//                log.info("判断能不能回收list大小：{}, count={}", list.size(), count);
                //当list内存到达512m，就通知gc回收堆
                if (list.size() >= count) {
//                    System.out.println("清理list.... 回收jvm内存....");
                    log.info("清理list.... 回收jvm内存....");
                    list.clear();
                    //通知gc回收
                    log.info("开始GC。。。。。。。。。。。。。。。。。。。");
                    System.gc();
                    //打印堆内存信息
                    printJvmMemoryInfo();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "clear memory").start();

        //阻止程序退出
        Thread.currentThread().join();
    }

    public void addObject2List(List list, int count) {
        for (int i = 0; i < count; i++) {
            OOMobject ooMobject = new OOMobject();
            //向list添加一个1m的对象
            list.add(ooMobject);
            try {
                //休眠100毫秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class OOMobject{
        //生成1m的对象
        private final byte[] bytes=new byte[1024*1024];
    }

    public static void printJvmMemoryInfo() {
        // 虚拟机级内存情况查询
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory() / byteToMb;
        vmFree = rt.freeMemory() / byteToMb;
        vmMax = rt.maxMemory() / byteToMb;
        vmUse = vmTotal - vmFree;
//        System.out.println("");
//        System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
//        System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
//        System.out.println("JVM总内存空间为：" + vmTotal + " MB");
//        System.out.println("JVM总内存最大堆空间为：" + vmMax + " MB");
//        System.out.println("");

        log.info("");
        log.info("JVM内存已用的空间为：{} MB", vmUse);
        log.info("JVM内存的空闲空间为：{} MB", vmFree);
        log.info("JVM总内存空间为：{} MB", vmTotal);
        log.info("JVM总内存最大堆空间为：{} MB", vmMax);
        log.info("");

    }



}
