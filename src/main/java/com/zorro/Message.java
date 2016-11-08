package com.zorro;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class Message {

    private final String HOSTNAME = "localhost";
    private String username;
    private String password;
    private String to_username;
    private String to;
    private final int CLIENTPORT = 5222;

    public void sendMessage(String text) {

        ConnectionConfiguration config = new ConnectionConfiguration(HOSTNAME, CLIENTPORT);
        XMPPConnection conn = new XMPPConnection(config);

        username = "test3";
        password = "test3";

        to_username = "test";
        to = to_username + "@localhost";

        try {
            conn.connect();
            conn.login(username, password);

            sendMessage(conn, to, text);

            conn.disconnect();


        } catch (XMPPException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(XMPPConnection conn, String to, String message_body) {
        org.jivesoftware.smack.packet.Message message = new org.jivesoftware.smack.packet.Message(to, org.jivesoftware.smack.packet.Message.Type.normal);
        message.setBody(message_body);
        conn.sendPacket(message);
        System.out.println("Message sent!");
    }
}
