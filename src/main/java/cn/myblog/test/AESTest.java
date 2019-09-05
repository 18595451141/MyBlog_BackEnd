package cn.myblog.test;

import cn.myblog.util.AES128Utils;
import cn.myblog.util.AES256Utils;
import cn.myblog.util.SHA512Utils;

public class AESTest {
    public static void main(String[] args) {
        String Key="1eeb68ab2c5b9efd50439bdf493e29e0abff58f77b64399034ad99c70e55d1b5";
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
        /*SHA256位加密*/
        String strResult256=SHA512Utils.SHA256("WangHongDi");
        System.out.println("SHA256位加密长度：" + strResult256.length());
        System.out.println("SHA256位加密：" + strResult256);
        /*SHA512位加密*/
        String strResult512=SHA512Utils.SHA512("WangHongDi");
        System.out.println("SHA512位加密长度：" + strResult512.length());
        System.out.println("SHA512位加密：" + strResult512);



    }
}
