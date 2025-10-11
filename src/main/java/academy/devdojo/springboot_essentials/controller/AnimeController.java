package academy.devdojo.springboot_essentials.controller;

import academy.devdojo.springboot_essentials.domain.Anime;
import academy.devdojo.springboot_essentials.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController // Criar APIs REST que retornam dados em formato JSON/XML
@RequestMapping("/anime") // Definir rotas - Dizer qual URL vai executar qual metodo do controller
@Log4j2 // Controlar e organizar as mensagens que sua aplicação imprime no console, arquivos, etc.
public class AnimeController {

    @Autowired // Injeção de Dependencias
    private DateUtil dateUtil;

    @GetMapping("/list") // Mapear requisições GET - Buscar/ler dados do servidor.
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }
}
