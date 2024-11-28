package bcc.ifsuldeminas.sistemaDeTelefonia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello() { return "Hello, world!"; }

    @GetMapping("{nome}")
    public String ola(@PathVariable String nome) { return "Olá, " + nome + "!"; }
}
