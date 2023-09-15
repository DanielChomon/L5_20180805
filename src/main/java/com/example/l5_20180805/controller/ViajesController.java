package com.example.l5_20180805.controller;

import com.example.l5_20180805.entity.Viajes;
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
@RequestMapping("/viajes")
public class ViajesController {

    final ViajesRepository viajesRepository;

    public ViajesController(ViajesRepository viajesRepository) {
        this.viajesRepository = viajesRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarViajes(Model model) {

        List<Viajes> lista = viajesRepository.findAll();
        model.addAttribute("viajesList", lista);

        return "viajes/list";
    }

    @GetMapping("/new")
    public String nuevoViajesFrm() {
        return "viajes/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoViajes(Viajes viajes, RedirectAttributes attr) {
        viajesRepository.save(viajes);
        return "redirect:/viajes/list";
    }

    @GetMapping("/edit")
    public String editarViajes(Model model,
                                      @RequestParam("id") int id) {

        Optional<Viajes> optViajes = viajesRepository.findById(id);

        if (optViajes.isPresent()) {
            Viajes viajes = optViajes.get();
            model.addAttribute("viajes", viajes);
            return "viajes/editFrm";
        } else {
            return "redirect:/viajes/list";
        }
    }

    @GetMapping("/delete")
    public String borrarViajes(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Viajes> optViajes = viajesRepository.findById(id);

        if (optViajes.isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/viajes/list";

    }
}
