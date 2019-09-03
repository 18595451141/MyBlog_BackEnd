package cn.myblog.test;

import cn.myblog.util.AES128Utils;
import cn.myblog.util.AES256Utils;

public class AESTest {
    public static void main(String[] args) {
        String Key="wanghongdi";
        /*AES128位加密*/
        String Content128="1";
        String miwen = AES128Utils.ecodes(Content128,Key);
        String mingwen = AES128Utils.dcodes(miwen, Key);
        System.out.println("密文：" + miwen);
        System.out.println("长度：" + miwen.length());
        System.out.println("128位解密：" + mingwen);
        /*AES256位加密*/
        String Content256 = "1";
        byte[] encryptResult = AES256Utils.encrypt(Content256, Key);
        String decryptResult = AES256Utils.decrypt(encryptResult, Key);
        System.out.println("密文：" + AES256Utils.parseByte2HexStr(encryptResult));
        System.out.println("长度：" + AES256Utils.parseByte2HexStr(encryptResult).length());
        System.out.println("256位解密：" + decryptResult);
    }
}
