package com.example.kafka.messaging.controller.nio;

import com.example.kafka.messaging.controller.MessageBroker;
import com.example.kafka.messaging.domain.BrokerConfiguration;
import com.example.kafka.messaging.service.MessageService;

/**
 * NIO 기반 브로커 구현 (Selector 기반 Reactor 패턴)
 */
public class NioBroker implements MessageBroker {

    private final BrokerConfiguration config;
    private final MessageService messageService;
    private volatile boolean running = false;

    public NioBroker(BrokerConfiguration config, MessageService messageService) {
        this.config = config;
        this.messageService = messageService;
    }

    @Override
    public void start() throws Exception {
        // TODO: NIO Reactor 시작
        running = true;
    }

    @Override
    public void stop() throws Exception {
        // TODO: NIO Reactor 종료
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

