package chapter01_basic.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/19 15:37
 */
public class Demo1 {

    public static void main(String[] args) {

    }

    public static String processFile() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
