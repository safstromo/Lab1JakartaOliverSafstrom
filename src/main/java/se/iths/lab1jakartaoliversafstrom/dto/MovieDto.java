package se.iths.lab1jakartaoliversafstrom.dto;

public class MovieDto {

    private int year;
    private String Name;

    public MovieDto(int year, String name) {
        this.year = year;
        Name = name;
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
