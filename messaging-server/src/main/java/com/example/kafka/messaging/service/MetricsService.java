package com.example.kafka.messaging.service;

import com.example.kafka.messaging.domain.LatencyRecord;
import com.example.kafka.messaging.domain.MetricsSummary;

import java.util.List;

/**
 * 메트릭 계산 서비스
 */
public class MetricsService {

    /**
     * LatencyRecord 리스트로부터 MetricsSummary 생성
     */
    public MetricsSummary summarize(List<LatencyRecord> records, long durationMs) {
        if (records.isEmpty()) {
            return new MetricsSummary(0, 0, 0, 0, 0);
        }

        long[] latencies = records.stream()
                .mapToLong(LatencyRecord::latencyNanos)
                .sorted()
                .toArray();

        double avgLatencyMs = average(latencies) / 1_000_000.0;
        double p95LatencyMs = percentile(latencies, 95) / 1_000_000.0;
        double p99LatencyMs = percentile(latencies, 99) / 1_000_000.0;
        double throughput = records.size() / (durationMs / 1000.0);

        return new MetricsSummary(records.size(), avgLatencyMs, p95LatencyMs, p99LatencyMs, throughput);
    }

    private double average(long[] values) {
        long sum = 0;
        for (long v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }

    private double percentile(long[] sortedValues, int percentile) {
        int index = (int) Math.ceil(percentile / 100.0 * sortedValues.length) - 1;
        return sortedValues[Math.max(0, index)];
    }
}

