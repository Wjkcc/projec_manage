package com.echair.project_manage.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @description:
 * @author: wjk
 * @date: 2020/8/25 16:36
 **/
@Component
public class TokenUtils {
    @Value("${token.sign}")
    private String JWT_SECRETs;
    private static final String JWT_SECRET  = "jwt";
    public String createToken(String data) {
        SecretKey secretKey = generalKey();
        //为了方便测试，我们将过期时间设置为30分钟
        long now = System.currentTimeMillis();//当前时间
        long exp = now + 1000*60*30; //过期时间为30分钟
        JwtBuilder builder= Jwts.builder()
                .setSubject(data)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .setExpiration(new Date(exp));
        return builder.compact();
    }
    public String checkToken(String token) {
        SecretKey secretKey=generalKey();
        Claims claims =
                Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public static void main(String[] args) {
        TokenUtils tokenUtils = new TokenUtils();
        String s = tokenUtils.createToken("222");
        System.out.println(s);
        String s1 = tokenUtils.checkToken(s);
        System.out.println(s1);
    }

    public SecretKey generalKey(){
        try {
            byte[] encodedKey = JWT_SECRET.getBytes(StandardCharsets.UTF_8);
            SecretKey secretKey = new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
            return secretKey;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
