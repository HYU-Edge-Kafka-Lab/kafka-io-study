package com.example.kafka.messaging.domain;

/**
 * 메시지 타입 정의
 */
public enum MessageType {

    PRODUCE((byte) 0x01),
    FETCH((byte) 0x02),
    ACK((byte) 0x03),
    ERROR((byte) 0xFF);

    private final byte code;

    MessageType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static MessageType fromCode(byte code) {
        for (MessageType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        return ERROR;
    }
}

