package com.echair.project_manage.task;

import com.echair.project_manage.dao.mapper.UserMapper;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/4 9:13
 **/
public class TaskTemplate<T> implements Runnable{
    private T data;
    private CountDownLatch countDownLatch;
    public TaskTemplate() {
        super();
    }
    public TaskTemplate(T data, CountDownLatch countDownLatch) {
        this.data = data;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {

    }
}
