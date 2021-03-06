package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * udp接收程序
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/20 15:54
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        datagramSocket.receive(packet);
        byte[] bytes1 = packet.getData();
        System.out.println(new String(bytes1, 0, packet.getLength()));
        datagramSocket.close();
    }

}
