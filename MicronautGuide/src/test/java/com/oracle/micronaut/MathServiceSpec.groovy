package com.oracle.micronaut

import com.oracle.micronaut.service.MathService
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class MathServiceSpec extends Specification {

    @Inject
    MathService mathService

    @Unroll
    void "should compute #num times 4"() {
        when:
        def result = mathService.compute(num)

        then:
        result == expected

        where:
        num | expected
        2   | 8
        3   | 12
    }
}
