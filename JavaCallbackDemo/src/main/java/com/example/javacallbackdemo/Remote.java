package com.example.javacallbackdemo;

public class Remote {

    /**
     * 模拟耗时操作
     * @param msg
     * @param callBack : 操作完成后，调用callBack类的方法将数据传回去
     */
    public void executeMessage(String msg,Callback callBack){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("excute msg:"+msg);
        msg = msg+"msg change...";
        callBack.execute(msg);
    }
}
