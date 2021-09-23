package main;

public class NewReleaseMovie extends Movie{
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
