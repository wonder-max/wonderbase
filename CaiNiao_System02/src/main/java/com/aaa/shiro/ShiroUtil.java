package com.aaa.shiro;

import com.aaa.util.MyConstants;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

import java.util.UUID;


public class ShiroUtil {
    /**
     * 传入一个明文返回一个加密之后的密文
     */
    public static  String getciphertext(String phertext){
        String ciphertext = DigestUtils.md5DigestAsHex(phertext.getBytes());
        return ciphertext;
    }

    /**
     * 加盐加密
     * @param salt
     * @param message
     * @return
     */
    public static String  encryptionBySalt(String salt,String message){
        //String algorithmName 加密算法, Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName= MyConstants.algorithmName;
        int hashIterations=MyConstants.hashIterations;
        SimpleHash simpleHash=new SimpleHash(algorithmName,message,salt,hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        String message="1111";
        String s = getciphertext(message);
        System.out.println(s);
       //shiro加密
        //String algorithmName, Object source, Object salt, int hashIterations
       /* String algorithmName="MD5";
        String source="I love you";
        String salt=UUID.randomUUID().toString();
        int hashIterations=1000;
        SimpleHash simpleHash= new SimpleHash(algorithmName,  source,  salt,  hashIterations);
        System.out.println("加密之后的密文："+ simpleHash);
        System.out.println("加密时用的盐："+salt);*/
        String salt= "ff4b64c6-592e-4258-9180-b3e6f8d05603";
        System.out.println("f04974722690306d29c52a3f0ca7c966");
        String encryption = encryptionBySalt(salt, message);
        System.out.println(encryption);

    }
}
