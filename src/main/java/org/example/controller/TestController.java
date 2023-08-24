package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.entity.SysUser;
import org.example.services.SysUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test" )
public class TestController {

    private final SysUserService userService;

    @GetMapping("/user")
    public Object user(){
        List<SysUser> list = userService.list();
        return list;
    }

    @PostMapping()
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean login = userService.login(username, password);
        if(login){
            return "succeed";
        }else {
            return "false";
        }
    }
}
