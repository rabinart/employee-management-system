package com.rabinart.ems.http.controller;


import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("employees", employeeService.findAll());

        return "employees";
    }
    @GetMapping("/{id}")
    public String findById(Model model,
                           @PathVariable Integer id){
        var maybeEmp = employeeService.findById(id);
        if (maybeEmp.isPresent()){
            model.addAttribute("employees", maybeEmp.get());
        }
        else return "404";
        return "employees";
    }

    @PostMapping
    public String create(EmployeeCreateEditDto dto){
        var id = employeeService.create(dto);
        return "redirect:employees/" + id;
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         EmployeeCreateEditDto dto){
        employeeService.update(id, dto);
        return "redirect:employee/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
//        employeeService.delete(id);
        return "redirect:employees";
    }
}
