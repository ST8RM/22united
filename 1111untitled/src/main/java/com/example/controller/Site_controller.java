package com.example.controller;

import com.example.repository.Repos;
import com.example.models.Name1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@Controller

public class Site_controller {

    @Autowired
    private Repos repos;



    @GetMapping("/market")
    public String markt(Model model) {
        Iterable<Name1> name1 = repos.findAll();
        model.addAttribute("name1", name1);
        return ("blocks/market");


    }

    @GetMapping("/market1")
    public String markt1(Model model) {
        Iterable<Name1> name1 = repos.findAll();
        model.addAttribute("name1", name1);
        return ("blocks/market");


    }

    @GetMapping("/market/add")
    public String categ(Model model) {
        return ("blocks/addProduct");
    }

    @PostMapping("/market/add")

    public String category(@RequestParam String name, @RequestParam String description, @RequestParam Integer price, Model model) {//@RequestBody
        Name1 name1 = new Name1(name, description, price);

        repos.save(name1);
        return "redirect:/market1";
    }


    @GetMapping("/market/{id}")
    public String NewsInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Name1> post = repos.findById(id);
        ArrayList<Name1> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("blocks/Market_Details");
    }

    @GetMapping("/market/{id}/edit")
    public String NewsEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Name1> post = repos.findById(id);
        ArrayList<Name1> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("blocks/Market_Edit");
    }

    @PostMapping("/market/{id}/edit")
    public String NewsPostEdd(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String description, @RequestParam Integer price, Model model) {
        Name1 name1 = repos.findById(id).orElseThrow();
        name1.setName(name);
        name1.setDescription(description);
        name1.setPrice(price);
        repos.save(name1);
        return "redirect:/market";
    }

    @DeleteMapping("/market/{id}/delete")
    public String NewsPostdel(@PathVariable(value = "id") long id, Model model) {
        Name1 name1 = repos.findById(id).orElseThrow();
        repos.delete(name1);
        return "redirect:/market";
    }

}


