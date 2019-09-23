package indi.daniel.archessm.interfaces.web.controller.test;

import indi.daniel.archessm.interfaces.shared.response.ResponseStatus;
import indi.daniel.archessm.repository.dao.IdentityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/echo_status")
    public ResponseStatus echo(@RequestBody ResponseStatus responseStatus) {
        return responseStatus;
    }
}
