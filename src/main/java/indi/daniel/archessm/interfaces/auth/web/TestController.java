package indi.daniel.archessm.interfaces.auth.web;

import indi.daniel.archessm.interfaces.common.response.ResponseStatus;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private IdentityGenerator identityGenerator;
    @GetMapping("/nextId")
    @ResponseBody
    public Long getNextId() {
        return identityGenerator.getNextId("t_user");
    }

    @PostMapping("/echo_status")
    @ResponseBody
    public ResponseStatus echo(@RequestBody ResponseStatus responseStatus) {
        return responseStatus;
    }
}
