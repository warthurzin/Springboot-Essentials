package academy.devdojo.springboot_essentials.repository;

import academy.devdojo.springboot_essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    // Conexão com o banco de dados
    List<Anime> listAll();
}
