package com.example.kafka.messaging.domain;

/**
 * 메트릭 요약 정보
 */
public record MetricsSummary(
        long totalMessages,
        double avgLatencyMs,
        double p95LatencyMs,
        double p99LatencyMs,
        double throughputPerSec
) {
    @Override
    public String toString() {
        return String.format(
            "MetricsSummary{total=%d, avgLatency=%.2fms, p95=%.2fms, p99=%.2fms, throughput=%.2f msg/s}",
            totalMessages, avgLatencyMs, p95LatencyMs, p99LatencyMs, throughputPerSec
        );
    }
}
