package com.example.kafka.messaging.controller;

/**
 * 메시지 브로커 공통 인터페이스
 * NIO/Netty 구현체가 이 인터페이스를 구현함
 */
public interface MessageBroker {

    void start() throws Exception;

    void stop() throws Exception;

    boolean isRunning();
}

