package com.lexue.account.controller;

import com.lexue.account.model.User;
import com.lexue.account.service.SysAccountService;
import com.lexue.common.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/demo")
@RestController
public class DemoController {
    @Autowired
    private SysAccountService sysAccountService;

    @GetMapping("")
    public String demo(){
        return "account demo!";
    }
    @GetMapping("/list")
    public List<User> list(){
        User user = new User();
        user.setAddress("栾城区");
        Page page = new Page();
        page.setPageSize(3);
        page.setStart(2);
        page.setCurrentPageNum(2);
        return sysAccountService.getList(page,user);

    }
}
