package ie.simo.movies.domain;

import ie.simo.movies.util.RandomNumberProvider;

import java.util.Random;

/**
 * Enum to represent Genre and box office appeal
 * 
 * @author Simon Wielens
 * 
 */
public enum Genre {
	Action(1.0), 
	Horror(0.6), 
	Romance(0.7), 
	Comedy(0.8), 
	Drama(0.8), 
	ScienceFiction(0.6),
	Kids(0.7);

	private final double boxOffice;

	Genre(double boxOffice) {
		this.boxOffice = boxOffice;
	}

	public double boxOffice() {
		return boxOffice;
	}

	
	public static Genre getRandomGenre() {
		Genre[] genres = Genre.values();
		Random r = RandomNumberProvider.getInstance();
		return genres[r.nextInt(genres.length)];
	}
}