package com.example.kafka.messaging.domain;

/**
 * 브로커 공통 설정
 */
public record BrokerConfiguration(int port, int numThreads) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int port = 9092;
        private int numThreads = Runtime.getRuntime().availableProcessors();

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder numThreads(int numThreads) {
            this.numThreads = numThreads;
            return this;
        }

        public BrokerConfiguration build() {
            return new BrokerConfiguration(port, numThreads);
        }
    }
}
