public class Rental {
    private Movie movie; // 영화
    private int dayRented; // 대여일수

    public Rental(Movie movie, int dayRented){
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }
}
