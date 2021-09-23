package main;

public abstract class Movie {

    public static final int CHILDRENS = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;

    private String _title;

    public Movie(String title) {
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    public static Movie movieFactory(String title, int priceCode) {
        if (priceCode == REGULAR)
            return new RegularMovie(title);
        if (priceCode == NEW_RELEASE)
            return new NewReleaseMovie(title);
        if (priceCode == CHILDRENS)
            return new ChildrensMovie(title);

        throw new RuntimeException("Not found movie");
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

    public abstract double getAmount(int daysRented);
}