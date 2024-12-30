package com.jyujyu.review.api;


import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryAPI {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa(){
        return testService.findAllByNameByJPA("juju");
    }

    @GetMapping("/test/query/querydsl/{name}")
    public List<TestEntity> queryQuerydsl(
            @PathVariable("name") String name
    ){
        return testService.findAllByNameByQuerydsl(name);
    }
}
