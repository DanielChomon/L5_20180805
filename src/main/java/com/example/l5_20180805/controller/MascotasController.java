package com.example.l5_20180805.controller;


import com.example.l5_20180805.entity.Mascotas;
import com.example.l5_20180805.repository.MascotasRepository;
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
@RequestMapping("/mascotas")
public class MascotasController {

    final MascotasRepository mascotasRepository;

    public MascotasController(MascotasRepository mascotasRepository) {
        this.mascotasRepository = mascotasRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarMascotas(Model model) {

        List<Mascotas> lista = mascotasRepository.findAll();
        model.addAttribute("mascotasList", lista);

        return "mascotas/list";
    }

    @GetMapping("/new")
    public String nuevoVMascotasFrm() {
        return "mascotas/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoMascotas(Mascotas mascotas, RedirectAttributes attr) {
        mascotasRepository.save(mascotas);
        return "redirect:/mascotas/list";
    }

    @GetMapping("/edit")
    public String editarMascotas(Model model,
                               @RequestParam("id") int id) {

        Optional<Mascotas> optMascota = mascotasRepository.findById(id);

        if (optMascota.isPresent()) {
            Mascotas mascotas = optMascota.get();
            model.addAttribute("mascotas", mascotas);
            return "mascotas/editFrm";
        } else {
            return "redirect:/mascotas/list";
        }
    }

    @GetMapping("/delete")
    public String borrarMascotas(Model model,
                               @RequestParam("id") int id,
                               RedirectAttributes attr) {

        Optional<Mascotas> optMascota = mascotasRepository.findById(id);

        if (optMascota.isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/mascotas/list";

    }
}
