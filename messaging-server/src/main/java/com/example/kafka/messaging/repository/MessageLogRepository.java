package com.example.kafka.messaging.repository;

import com.example.kafka.messaging.domain.Message;

/**
 * 메시지 로그 저장소 인터페이스
 */
public interface MessageLogRepository {

    void append(Message message) throws Exception;

    Message read(long offset) throws Exception;
}

