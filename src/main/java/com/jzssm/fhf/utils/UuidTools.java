package com.jzssm.fhf.utils;

import java.util.UUID;

/**
 * @author ：Angular
 * @ProjectName: zuihou-admin-cloud
 * @Package: com.github.zuihou.esap.utils
 * @ClassName: uuidTools
 * @date ：Created in 2021/1/7 15:56
 * @description：自动生成8位uuid值
 * @modified By：
 * @version: v1.0.0$
 */
public class UuidTools {
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }


    public static String getUuidNum(){
        String[] chars = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        StringBuffer shortBuffer = new StringBuffer();
            String uuid = UUID.randomUUID().toString().replace("-","");
            for (int j=0;j<8;j++) {
                String str=uuid.substring(j*4,j*4+4);
                int par=Integer.parseInt(str,16);
                shortBuffer.append(chars[par % 10]);
        }
        return shortBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(getUuidNum());;
    }
}
