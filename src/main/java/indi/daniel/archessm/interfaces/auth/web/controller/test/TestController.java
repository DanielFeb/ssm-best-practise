package indi.daniel.archessm.interfaces.auth.web.controller.test;

import indi.daniel.archessm.common.interfaces.response.ResponseStatus;
import indi.daniel.archessm.repository.IdentityGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private IdentityGenerator identityGenerator;
    @GetMapping("/nextId")
    public Long getNextId() {
        return identityGenerator.getNextId("t_user");
    }

    @PostMapping("/echo_status")
    public ResponseStatus echo(@RequestBody ResponseStatus responseStatus) {
        return responseStatus;
    }
}
