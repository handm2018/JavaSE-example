package io.stream;

import java.io.File;
import java.io.IOException;

/**
 * File相关的功能示例
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/26 9:49
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        // 文件相关
        File file = new File("E:\\Code\\IdeaProjects\\MyProjects\\a.txt");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println("文件创建成功！");
        }
        System.out.println("文件名" + file.getName());
        System.out.println("父级" + file.getParent());
        System.out.println("绝对路径" + file.getAbsolutePath());
        System.out.println("路径" + file.getPath());

        // 文件夹、目录相关
        File dir = new File("E:\\a");
        if (!dir.exists()) {
            boolean mkdir = dir.mkdir();
            System.out.println("创建目录成功！");
        }
        boolean directory = dir.isDirectory();

        File dirs = new File("E:\\c\\d\\e");
        if (!dirs.exists()) {
            boolean mks = dirs.mkdirs();
            System.out.println("创建多级目录成功！");
        }
    }

}
