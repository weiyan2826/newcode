package com.spw.newcode.controller;

import com.spw.newcode.entity.DiscussPost;
import com.spw.newcode.entity.Page;
import com.spw.newcode.entity.User;
import com.spw.newcode.service.DiscussPostService;
import com.spw.newcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        // 方法调用前,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.

        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> lists=new ArrayList<>();
        List<DiscussPost> lists2 = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
            for (DiscussPost list : lists2) {
                String name= userService.findUserById(list.getUserId()).getUsername();
                String url=userService.findUserById(list.getUserId()).getHeaderUrl();
                list.setName(name);
                list.setUrl(url);
                lists.add(list);
            }
        model.addAttribute("lists", lists);
        return "/index";
    }

}
