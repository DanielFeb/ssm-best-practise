package indi.daniel.archessm.controller;

import indi.daniel.archessm.dao.IdentityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private IdentityMapper identityMapper;
    @GetMapping("/nextId")
    public Integer getNextId() {
        return identityMapper.getNextID("t_user");
    }
}
