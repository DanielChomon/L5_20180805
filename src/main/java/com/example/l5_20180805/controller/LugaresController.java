package com.example.l5_20180805.controller;


import com.example.l5_20180805.entity.Lugares;
import com.example.l5_20180805.entity.Viajes;
import com.example.l5_20180805.repository.LugaresRepository;
import com.example.l5_20180805.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lugares")
public class LugaresController {

    final LugaresRepository lugaresRepository;

    public LugaresController(LugaresRepository lugaresRepository) {
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarLugares(Model model) {

        List<Lugares> lista = lugaresRepository.findAll();
        model.addAttribute("lugaresList", lista);

        return "lugares/list";
    }

    @GetMapping("/new")
    public String nuevoLugaresFrm() {
        return "lugares/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoLugares(Lugares lugares, RedirectAttributes attr) {
        lugaresRepository.save(lugares);
        return "redirect:/lugares/list";
    }

    @GetMapping("/edit")
    public String editarLugares(Model model,
                               @RequestParam("id") int id) {

        Optional<Lugares> optLugares = lugaresRepository.findById(id);

        if (optLugares.isPresent()) {
            Lugares lugares = optLugares.get();
            model.addAttribute("lugares", lugares);
            return "lugares/editFrm";
        } else {
            return "redirect:/lugares/list";
        }
    }

    @GetMapping("/delete")
    public String borrarLugares(Model model,
                               @RequestParam("id") int id,
                               RedirectAttributes attr) {

        Optional<Lugares> optLugares = lugaresRepository.findById(id);

        if (optLugares.isPresent()) {
            lugaresRepository.deleteById(id);
        }
        return "redirect:/lugares/list";

    }


}
