package indi.daniel.archessm.controller;

import indi.daniel.archessm.dao.IdMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private IdMapper idMapper;
    @GetMapping("/nextId")
    public Integer getNextId() {
        return idMapper.getNextID("t_user");
    }
}
