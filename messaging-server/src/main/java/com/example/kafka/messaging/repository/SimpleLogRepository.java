package com.example.kafka.messaging.repository;

import com.example.kafka.messaging.domain.Message;

/**
 * 단순 파일 기반 로그 저장소 구현
 */
public class SimpleLogRepository implements MessageLogRepository {

    @Override
    public void append(Message message) throws Exception {
        // TODO: 파일에 메시지 append
    }

    @Override
    public Message read(long offset) throws Exception {
        // TODO: 파일에서 메시지 읽기
        return null;
    }
}

