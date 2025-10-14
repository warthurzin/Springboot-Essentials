package academy.devdojo.springboot_essentials.controller;

import academy.devdojo.springboot_essentials.domain.Anime;
import academy.devdojo.springboot_essentials.service.AnimeService;
import academy.devdojo.springboot_essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // Criar APIs REST que retornam dados em formato JSON/XML
@RequestMapping("/animes") // Definir rotas - Dizer qual URL vai executar qual metodo do controller
@Log4j2 // Controlar e organizar as mensagens que sua aplicação imprime no console, arquivos, etc.
@RequiredArgsConstructor
public class AnimeController {
    // End-Points
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping // Mapear requisições GET - Buscar/ler dados do servidor.
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime) {
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
