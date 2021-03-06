package net.udp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/19 16:58
 */
public class InetDemo {

    public static void main(String[] args) throws IOException {
        // 获取本机
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.isReachable(3000));
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());

        System.out.println("--------------我是一条分割线-------------");

        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        System.out.println(address.getHostAddress());
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.isLoopbackAddress());
    }

}
