package com.example.javacallbackdemo;

/**
 * 回调接口
 */
public interface Callback <T> {
    /**
     * 操作完毕后，回调execute方法
     * @param data : 操作完毕后得到的数据
     */
    void execute(T data);
}
