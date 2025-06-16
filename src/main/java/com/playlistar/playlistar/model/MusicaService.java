package com.playlistar.playlistar.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

    @Autowired
    MusicaDAO mdao;

    public void inserirMusica(Musica mus){
        mdao.inserirMusica(mus);
    }

    public List<Musica> puxarTodasMusicas(){   
        return Musica.converterVarios(mdao.puxarTodasMusicas());
    }

    public Musica puxarMusica(int id){
        return Musica.converter(mdao.puxarMusica(id));
    }

    public void atualizarMusica(int id, Musica mus){
        mdao.atualizarMusica(id, mus);
    }

    public void deletarMusica(int id){
        mdao.deletarMusica(id);
    }
}
