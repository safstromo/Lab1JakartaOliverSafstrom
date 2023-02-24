package se.iths.lab1jakartaoliversafstrom.dto;

import se.iths.lab1jakartaoliversafstrom.entity.Movie;

import java.util.function.Consumer;

public class MovieDto {
    private Long id;
    private int year;
    private String Name;

    public MovieDto(int year, String name) {
        this.year = year;
        Name = name;
    }

    public MovieDto(Movie movie) {
        this.Name = movie.getName();
        this.year = movie.getYear();
        this.id = movie.getId();
    }

    public MovieDto() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
