package com.yikai.retiredsoldier;

/**
 * @Description
 * @Author yikai.wang
 * @Date 2019/2/14 9:19
 */
public class ThreadDemo implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
