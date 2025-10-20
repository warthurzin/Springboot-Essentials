package academy.devdojo.springboot_essentials.service;

import academy.devdojo.springboot_essentials.domain.Anime;
import academy.devdojo.springboot_essentials.repository.AnimeRepository;
import academy.devdojo.springboot_essentials.requests.AnimePostRequestBody;
import academy.devdojo.springboot_essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {
    // Responsavel pela lógica de négocio
    private final AnimeRepository animeRepository;

    public List<Anime> listAll()  {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id)  {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(animePutRequestBody.getId())
                .name(animePutRequestBody.getName()).build();
        animeRepository.save(anime);
    }
}
