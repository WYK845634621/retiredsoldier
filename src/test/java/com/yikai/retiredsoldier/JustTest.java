package com.yikai.retiredsoldier;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.Hashtable;

/**
 * @Description
 * @Author yikai.wang
 * @Date 2019/2/14 8:50
 */
public class JustTest {
    @Test
    public void test(){
        System.out.println("ok");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        while (true){
            if (threadDemo.isFlag()){
                System.out.println("==========");
                break;
            }
        }
    }

    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int i = 10;
        i = i++;
        i = i++;
        System.out.println(i);
    }

    @Test
    public void test3(){
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("王艺楷","王艺楷");
        hashtable.isEmpty();

    }
}
