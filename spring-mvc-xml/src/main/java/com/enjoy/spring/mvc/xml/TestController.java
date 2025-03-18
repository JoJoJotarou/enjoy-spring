package com.enjoy.spring.mvc.xml;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mvc/xml")
public class TestController {

    private final HelloDao helloDao;

    public TestController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @GetMapping("hello")
    public String hello() {
        return helloDao.hello();
    }
}
