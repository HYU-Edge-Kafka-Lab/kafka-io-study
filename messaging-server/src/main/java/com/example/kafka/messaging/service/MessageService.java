package com.example.kafka.messaging.service;

import com.example.kafka.messaging.domain.Message;

/**
 * 메시지 처리 서비스 인터페이스 (비즈니스 로직)
 */
public interface MessageService {

    Message handleMessage(Message request);
}

