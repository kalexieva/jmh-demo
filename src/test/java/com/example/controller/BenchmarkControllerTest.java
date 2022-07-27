package com.example.controller;

import com.example.AbstractBenchmark;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@MicronautTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BenchmarkControllerTest extends AbstractBenchmark {

    BenchmarkController benchmarkController;

    @Setup(Level.Trial)
    public void setupBenchmark() {
        benchmarkController = new BenchmarkController();
    }

    @Benchmark
    public void witcherBenchmark(Blackhole blackhole) {
        blackhole.consume(benchmarkController.getWitcherCharacters());
    }

    @Benchmark
    public void lebowskiBenchmark(Blackhole blackhole) {
        blackhole.consume(benchmarkController.getLebowskiQuotes());
    }
}