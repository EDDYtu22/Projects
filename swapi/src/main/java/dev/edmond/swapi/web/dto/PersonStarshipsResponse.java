package dev.edmond.swapi.web.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonStarshipsResponse {
    private Set<Integer> personStarships;
}
