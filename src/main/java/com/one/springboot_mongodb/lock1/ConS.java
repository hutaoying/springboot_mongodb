package com.one.springboot_mongodb.lock1;

public class ConS implements Runnable {
    private ProCon proCon;
    public ConS( ProCon proCon){
        this.proCon = proCon;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                proCon.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
