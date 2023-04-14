package com.rabinart.ems.http.controller;

import com.rabinart.ems.database.dto.BusynessFilter;
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
    String findAll(Model model, BusynessFilter filter){
        model.addAttribute("filter", filter);
        model.addAttribute("busynesses", busynessService.findAllByFilter(filter));
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
