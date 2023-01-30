package com.oracle.micronaut;

import com.oracle.micronaut.service.MathService;
import io.micronaut.http.HttpRequest;
import io.micronaut.test.extensions.spock.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import spock.lang.Specification;
import spock.lang.Unroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class MathServiceTest extends Specification {

    @Inject
    MathService mathService;

    @Test
    public void testMain() {
        assertEquals(8, mathService.compute(2));
        assertEquals(12, mathService.compute(3));
    }
}
