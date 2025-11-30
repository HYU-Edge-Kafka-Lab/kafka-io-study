package com.example.kafka.messaging.controller.netty;

import com.example.kafka.messaging.controller.MessageBroker;
import com.example.kafka.messaging.domain.BrokerConfiguration;
import com.example.kafka.messaging.service.MessageService;

/**
 * Netty 기반 브로커 구현 (EventLoop 기반)
 */
public class NettyBroker implements MessageBroker {

    private final BrokerConfiguration config;
    private final MessageService messageService;
    private volatile boolean running = false;

    public NettyBroker(BrokerConfiguration config, MessageService messageService) {
        this.config = config;
        this.messageService = messageService;
    }

    @Override
    public void start() throws Exception {
        // TODO: Netty ServerBootstrap 시작
        running = true;
    }

    @Override
    public void stop() throws Exception {
        // TODO: Netty EventLoopGroup 종료
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public BrokerConfiguration getConfig() {
        return config;
    }

    public MessageService getMessageService() {
        return messageService;
    }
}

