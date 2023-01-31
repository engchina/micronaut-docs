package com.oracle.micronaut.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;



@Controller("/issues")
public class IssuesController {

    // URI变量可以通过方法参数进行引用。
    @Get("/{number}")
    public String issue(@PathVariable Integer number) { // 方法参数可以选择用PathVariable来注解
        return "Issue # " + number + "!";
    }
}
