package io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStreamDemo
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/25 14:42
 */
public class InputStreamAndOutputStreamDemo {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("a.txt");
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                String msg = new String(bytes, 0, len);
                System.out.println(msg);
            }

            fos = new FileOutputStream("a.txt");
            String outMsg = "问君能有几多愁，恰似一江春水向东流";
            fos.write(outMsg.getBytes());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
