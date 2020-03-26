package com.one.springboot_mongodb.lock1;

public class Pro implements Runnable {
    private ProCon proCon;

    public Pro(ProCon proCon) {
        this.proCon = proCon;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                proCon.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
