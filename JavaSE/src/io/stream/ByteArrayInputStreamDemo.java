package io.stream;

import java.io.ByteArrayInputStream;

/**
 * ByteArrayInputStream
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/16 16:56
 */
public class ByteArrayInputStreamDemo {

    private static final int LEN = 5;
    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };
    private static final ByteArrayInputStream bis = new ByteArrayInputStream(ArrayLetters);
    public static void main(String[] args) {
//        new ByteArrayInputStream()
        testRead();
    }

    public static void testRead() {
        for (int i = 0; i < LEN; i++) {
            if (bis.available() > 0) {
                int tmp = bis.read();
                System.out.printf("%d : 0x%s\n", i, Integer.toHexString(tmp));
            }
        }



    }

}
