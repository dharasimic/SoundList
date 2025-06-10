package com.playlistar.playlistar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.playlistar.playlistar.model.Musica;
import com.playlistar.playlistar.model.MusicaService;

@Controller
public class PlaylistController {   
    
    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/newplaylist")
    public String adicionar(Model model){
        //iniciar com musica vazio no adicionar
        model.addAttribute("playlist", "DIGITE O NOME DA PLAYLIST");
        model.addAttribute("musica", new Musica());
        model.addAttribute("titulo", "ADICIONAR NOVA MUSICA");
        model.addAttribute("link", "/listarplaylist");
        model.addAttribute("valor", "Adicionar música");
        return "newplaylist";
    }

    @PostMapping("/listarplaylist")
    public String listarPlaylist(Model model, @ModelAttribute Musica mus){
        MusicaService ms = ctx.getBean(MusicaService.class);
        ms.inserirMusica(mus);
        return "redirect:listarplaylist";
    }

    @GetMapping("/listarplaylist")
    public String listarplaylist(Model model){
         MusicaService ms = ctx.getBean(MusicaService.class);
         List<Musica> lista = ms.puxarTodasMusicas();
         model.addAttribute("musicas", lista);
        return "listar";
    }





}
