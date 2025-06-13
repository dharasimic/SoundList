package com.playlistar.playlistar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//POJO
    //espelho da tabela
public class Musica {
    
    private int id;
    private String nomePlaylist, nomeMusica, artista;

        //para inicializar o formulario
    public Musica(){

    }

        //para cadastro
    public Musica(String nomePlaylist, String nomeMusica, String artista){
        this.nomePlaylist = nomePlaylist;
        this.nomeMusica = nomeMusica;
        this.artista = artista;
    }

        //para vizualização
    public Musica(int id, String nomePlaylist, String nomeMusica, String artista){
        this.id = id;
        this.nomePlaylist = nomePlaylist;
        this.nomeMusica = nomeMusica;
        this.artista = artista;
    }


    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }
    
    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }
    
    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }
    
    
    public String getArtista() {
        return artista;
    }
    
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public static Musica converter(Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nomePlaylist = (String) registro.get("nome_playlist");
        String nomeMusica = (String) registro.get("nome_musica");
        String artista = (String) registro.get("artista");

        return new Musica(id, nomePlaylist, nomeMusica, artista);
    }

    public static List<Musica> converterVarios(List<Map<String,Object>> registros){
        ArrayList<Musica> lista = new ArrayList<Musica>();
        for (Map<String,Object> reg: registros){
            lista.add(converter(reg));
        }
        return lista;
    }
}
