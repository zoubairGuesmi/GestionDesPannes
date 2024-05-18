package com.pannes.gestiondespannes.controller;

import com.pannes.gestiondespannes.entities.User;
import com.pannes.gestiondespannes.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/index")
    public String Users(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "2") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<User> pageUsers = userRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listUsers", pageUsers.getContent());
        model.addAttribute("pages", new int [pageUsers.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",keyword);
        return "users";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        userRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/formUsers")
    public String formUser(Model model){
        model.addAttribute("user", new User());
        return "formUsers";
    }

    @PostMapping("/save")
    public String saveUser(Model model,@Valid User user, BindingResult bindingResult,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String keyword){
        if (bindingResult.hasErrors())
            return "formUsers";
        userRepository.save(user);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/editUser")
    public String editUser(Model model, Long id, String keyword, int page){
        User user = userRepository.findById(id).orElse(null);
        if(user == null)
            throw new RuntimeException("user not found");
        model.addAttribute("user", user);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "editUser";
    }

}
