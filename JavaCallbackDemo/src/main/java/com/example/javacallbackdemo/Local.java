package com.example.javacallbackdemo;

public class Local implements Callback<String>, Runnable {

    public Remote remote;
    public String message;

    public Local(Remote remote,String message){
        this.remote = remote;
        this.message = message;
    }

    /***
     * 模拟耗时操作，开一个新线程进行操作
     */
    public void sendMessage(){
        System.out.println(Thread.currentThread().getName()+" current thread");
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        Local local = new Local(new Remote(), "hello World");
        local.sendMessage();
        System.out.println("main thread keep going...");
    }


    /**
     * 调用这个方法使得Remote的数据能够回到Local
     * @param msg : Remote传来的数据
     */
    @Override
    public void execute(String msg) {
        System.out.println(msg);
        System.out.println(Thread.currentThread().getName()+" current thread");
        System.out.println("done!");
    }

    /**
     * 新线程调用remote.executeMessage方法
     * 如何知道executeMessage方法已经完成了呢？
     * 传入callback类的接口，当executeMessage完成后，实现了接口方法的类会被调用
     * 这里就是this这个类实现的execute方法会被调用
     * 达到的效果就是新线程操作结束后得到的数据会传回到这里的execute方法的msg参数中
     */
    @Override
    public void run() {
        remote.executeMessage(message, this);
    }
}
