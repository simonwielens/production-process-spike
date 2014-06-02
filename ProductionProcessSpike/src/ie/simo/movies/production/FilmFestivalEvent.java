package ie.simo.movies.production;

import java.util.Random;

import ie.simo.movies.util.RandomNumberProvider;

public class FilmFestivalEvent extends ProductionEvent {
	
	private static final long serialVersionUID = 706465185225017632L;
	public static final String FESTIVAL_EVENT = "FilmFestivalEvent";
	private Random rng = RandomNumberProvider.getInstance();

	public FilmFestivalEvent(String festivalDetails, int goodBuzz, int badBuzz)
	{
		this.setType(FESTIVAL_EVENT);
		this.setBadBuzz(badBuzz);
		this.setGoodBuzz(goodBuzz);
		this.setTitle("Film Festival");
		this.setDescription(festivalDetails);
	}
}