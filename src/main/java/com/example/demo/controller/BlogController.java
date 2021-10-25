package com.example.demo.controller;


import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private PostService service;


    @GetMapping("/blog")
    public String blogMain(Model model){
        model.addAttribute("posts",service.findAll());
        return "blog-main";
    }



    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }


    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String fullText, Model model){
        Post post = new Post(title,anons,fullText);
        service.save(post);

        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String  blogDetails(@PathVariable(value = "id") int id, Model model){

if(!service.isExists(id)){
     return "redirect:/blog";

}
      Optional<Post> post= service.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-details";




    }


    @GetMapping("/blog/{id}/edit")
    public String  blogEdit(@PathVariable(value = "id") int id, Model model) {

        if (!service.isExists(id)) {
            return "redirect:/blog";

        }
        Optional<Post> post = service.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(
            @PathVariable(value = "id") int id,@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String fullText, Model model){
        Post post = service.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        service.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(
            @PathVariable(value = "id") int id, Model model){
        Post post = service.findById(id).orElseThrow();
        service.delete(post);
        return "redirect:/blog";
    }

}
