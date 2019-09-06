package cn.myblog.test;

import cn.myblog.util.AES128Utils;
import cn.myblog.util.AES256Utils;
import cn.myblog.util.CommonlyUsedUtils;
import cn.myblog.util.SHA512Utils;

import java.util.Random;

public class AESTest {
    public static void main(String[] args) {
        String Key="QRnj060QCu22T4IZ";
        /*AES128位加密*/
        String Content128="77AED1E8BA579012A9426CB183D65D533E82316B10A347E88F7A51C5903821ED874B61503878FF41535CF4D4CD3FB51D7E245F0E71C7A35ABD6BBD652B510B31E809612C795B274C1625A9DDAF928C6E4558D0BC1222926FEB6374331EEC7CF6BB1EE7BF0890BE19EC7A9A6178230C8E97A16BB282EF1A218A6C481A95B6F6729226FD65A5312C2DA920989BA4D63451";
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

        //77AED1E8BA579012A9426CB183D65D533E82316B10A347E88F7A51C5903821ED874B61503878FF41535CF4D4CD3FB51D7E245F0E71C7A35ABD6BBD652B510B31E809612C795B274C1625A9DDAF928C6E4558D0BC1222926FEB6374331EEC7CF6BB1EE7BF0890BE19EC7A9A6178230C8E97A16BB282EF1A218A6C481A95B6F6729226FD65A5312C2DA920989BA4D63451
        //QRnj060QCu22T4IZ

        //26d8ed9e7a7e62edb2d500e7f4430efdbc1ec6d35eae5c98574cc881e7ef06dd48f3def989a2b0ee556a382899a1eb4af7a930de9cb3d49a2f2d6195e1908e9b


        //随机数
        System.out.println("随机数："+ CommonlyUsedUtils.getRandomNumber(16));
    }
}
