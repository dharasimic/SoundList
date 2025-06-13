package com.playlistar.playlistar.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MusicaDAO {//data access object

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void inserirMusica(Musica mus){
        String sql = "INSERT INTO musica(nome_playlist, nome_musica, artista) VALUES (?,?,?)";
        Object[] parametros = new Object[3]; //um para cada valor ?
        parametros[0] = mus.getNomePlaylist();
        parametros[1] = mus.getNomeMusica();
        parametros[2] = mus.getArtista();
        jdbc.update(sql,parametros);
    }

    public List<Map<String, Object>> puxarTodasMusicas() {
        String sql = "SELECT * FROM musica ORDER BY nome_playlist";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarMusica(int id){
        String sql = "SELECT * FROM musica WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }


    public void atualizarMusica(int id, Musica mus){
        String sql = "UPDATE musica SET nome_playlist = ?, nome_musica = ?, artista = ? WHERE id = ?";
        Object[] parametros = new Object[4]; //um para cada valor ?
        parametros[0] = mus.getNomePlaylist();
        parametros[1] = mus.getNomeMusica();
        parametros[2] = mus.getArtista();
        parametros[3] = mus.getId();

        jdbc.update(sql,parametros);
    }

    public void deletarMusica(int id){
        String sql = "DELETE FROM musica WHERE id = ?";
        jdbc.update(sql,id);
    }
}
