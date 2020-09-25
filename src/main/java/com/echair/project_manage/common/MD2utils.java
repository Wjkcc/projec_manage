package com.echair.project_manage.common;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/3 15:18
 **/
public class MD2utils {
    public static String MD2(String str) throws NoSuchAlgorithmException {
        // 获取MD2加密工具
        MessageDigest md = MessageDigest.getInstance("MD2");
        // 加密
        byte[] digest = md.digest(str.getBytes());
        // 获取二进制十六进制互转工具
        HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
        // 将二进制数组转换为十六进制字符串,输出结果
        return hexBinaryAdapter.marshal(digest);
    }
}
