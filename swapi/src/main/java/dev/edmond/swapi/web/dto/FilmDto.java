package dev.edmond.swapi.web.dto;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmDto {
    @Id
    private Integer id;

    private String title;

    @Lob
    private String opening_crawl;

    private String director;

    private String producer;

    private String release_date;
   
    private String url;
}