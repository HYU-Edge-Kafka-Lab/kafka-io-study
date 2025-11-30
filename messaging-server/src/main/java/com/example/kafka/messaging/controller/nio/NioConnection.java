package com.example.kafka.messaging.controller.nio;

import java.nio.channels.SocketChannel;

/**
 * NIO 연결 관리
 */
public class NioConnection {

    private final SocketChannel channel;

    public NioConnection(SocketChannel channel) {
        this.channel = channel;
    }

    public SocketChannel getChannel() {
        return channel;
    }
}

