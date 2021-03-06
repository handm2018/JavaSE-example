package net.udp;

import java.io.IOException;
import java.net.*;

/**
 * udp协议，发送端
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/19 15:39
 */
public class UDPSender {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] msg = "this is a test msg".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(msg, msg.length,
                InetAddress.getByName("127.0.0.1"), 9999);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

}
