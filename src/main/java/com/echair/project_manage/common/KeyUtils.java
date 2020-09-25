package com.echair.project_manage.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/29 17:16
 **/
@Component
public class KeyUtils {
    public static String generateUserid() {
        return UUID.randomUUID().toString()+System.currentTimeMillis();
    }
}
