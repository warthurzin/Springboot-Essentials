package academy.devdojo.springboot_essentials.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class Anime {
    // Representa o que temos do banco de dados
    private Long id;
    private String name;
}
