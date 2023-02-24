package com.rabinart.ems.http.controller;

import com.rabinart.ems.service.BusynessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/busyness")
@RequiredArgsConstructor
public class BusynessController {

    private final BusynessService busynessService;

    @GetMapping
    String findAll(Model model){
        model.addAttribute("busynesses", busynessService.findAll());
        return "busynesses";
    }

    @GetMapping("/{id}")
    String findById(Model model, @PathVariable Long id){
        return busynessService.findById(id)
                .map(e -> {
                    model.addAttribute("busyness",e);
                    return "busyness";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
