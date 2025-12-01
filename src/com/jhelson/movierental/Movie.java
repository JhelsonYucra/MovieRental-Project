package com.jhelson.movierental;

public class Movie extends RentalItem {
    private String director;
    private int duration;      // minutos
    private String ageRating;  // clasificación
    private String genre;

    public Movie(String itemID, String itemName, String director, int duration, String ageRating, String genre) {
        super(itemID, itemName);
        this.director = director;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public String getAgeRating() { return ageRating; }
    public void setAgeRating(String ageRating) { this.ageRating = ageRating; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String showDetails() {
        return super.showDetails()
                + " | Director: " + director
                + " | Duración: " + duration + " min"
                + " | Clasificación: " + ageRating
                + " | Género: " + genre;
    }
}