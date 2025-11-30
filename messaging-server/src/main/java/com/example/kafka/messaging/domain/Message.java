package com.example.kafka.messaging.domain;

/**
 * 메시지 도메인 객체
 * 
 * 프로토콜 구조:
 * [4 byte] total_length
 * [8 byte] timestamp
 * [1 byte] message_type
 * [N byte] payload
 */
public record Message(long timestamp, MessageType type, byte[] payload) {

    public static final int LENGTH_FIELD_SIZE = 4;
    public static final int TIMESTAMP_FIELD_SIZE = 8;
    public static final int TYPE_FIELD_SIZE = 1;
    public static final int HEADER_SIZE = TIMESTAMP_FIELD_SIZE + TYPE_FIELD_SIZE;
    public static final int MAX_MESSAGE_SIZE = 1024 * 1024;

    public static Message produce(byte[] payload) {
        return new Message(System.nanoTime(), MessageType.PRODUCE, payload);
    }

    public static Message ack() {
        return new Message(System.nanoTime(), MessageType.ACK, new byte[0]);
    }

    public int getTotalLength() {
        return HEADER_SIZE + payload.length;
    }
}
