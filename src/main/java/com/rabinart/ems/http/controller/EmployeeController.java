package com.rabinart.ems.http.controller;


import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Integer id) {
        return employeeService.findById(id)
                .map(employee -> {
                    model.addAttribute("employee", employee);
                    return "employees";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(EmployeeCreateEditDto dto, PersonalInfoCreateEditDto info) {
        return "redirect:employees/" + employeeService.create(dto, info);
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, EmployeeCreateEditDto dto) {
        return employeeService.update(id, dto)
                .map(it -> "redirect:/employees/{id}")
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        if (!employeeService.delete(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return "redirect:employees";
    }
}
