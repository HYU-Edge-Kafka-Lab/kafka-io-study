package com.example.kafka.messaging.service;

import com.example.kafka.messaging.domain.Message;
import com.example.kafka.messaging.repository.MessageLogRepository;

/**
 * 메시지 처리 서비스 기본 구현
 * NIO/Netty 공통으로 사용
 */
public class DefaultMessageService implements MessageService {

    private final MessageLogRepository repository;

    public DefaultMessageService(MessageLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message handleMessage(Message request) {
        return switch (request.type()) {
            case PRODUCE -> handleProduce(request);
            case FETCH -> handleFetch(request);
            default -> Message.ack();
        };
    }

    private Message handleProduce(Message request) {
        try {
            repository.append(request);
            return Message.ack();
        } catch (Exception e) {
            return new Message(System.nanoTime(), 
                com.example.kafka.messaging.domain.MessageType.ERROR, 
                e.getMessage().getBytes());
        }
    }

    private Message handleFetch(Message request) {
        // TODO: offset 파싱 후 메시지 조회
        return Message.ack();
    }
}

