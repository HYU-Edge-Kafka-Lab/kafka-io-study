package com.example.kafka.messaging.domain;

/**
 * 지연 시간 기록
 */
public record LatencyRecord(long startTime, long endTime) {

    public long latencyNanos() {
        return endTime - startTime;
    }

    public double latencyMillis() {
        return latencyNanos() / 1_000_000.0;
    }
}
