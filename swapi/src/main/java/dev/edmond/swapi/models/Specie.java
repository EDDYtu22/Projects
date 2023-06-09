package dev.edmond.swapi.models;

import  java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String classification;

    private String designation;

    private String average_height;

    private String skin_colors;

    private String hair_colors;

    private String eye_colors;

    private String average_lifespan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Planet_ID")
    @JsonIgnoreProperties("species")
    private Planet planet;
    
    private String language;

    @ManyToMany(mappedBy = "species")
    @JsonIgnoreProperties("species")
    private Set<Person> persons;

    @ManyToMany(mappedBy = "species")
    @JsonIgnoreProperties("species")
    private Set<Film> films;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
