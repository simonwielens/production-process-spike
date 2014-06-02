package ie.simo.movies.production;

import java.util.Random;

import ie.simo.movies.util.RandomNumberProvider;

public class ScreeningEvent extends ProductionEvent {
	
	private static final long serialVersionUID = 706465185225017632L;
	public static final String SCREENING_EVENT = "ScreeningEvent";
	private Random rng = RandomNumberProvider.getInstance();

	public ScreeningEvent(String location, int progress)
	{
		if(location.length() < 1){
			location = "the studio lot";
		}
		this.setType(SCREENING_EVENT);
		ProductionEvent event = createScreening(location, progress);
		this.setBadBuzz(event.getBadBuzz());
		this.setGoodBuzz(event.getGoodBuzz());
		this.setTitle("Screening");
		this.setDescription(event.getDescription());
	}
	
	public ProductionEvent createScreening(String location, int progress) {
		int goodBuzz = rng.nextInt(7);
		int badBuzz = rng.nextInt(7);
		boolean isEarlyCut = progress < 30;
		
		String desc = "You held a screening in " + location + ". ";
		
		if(isEarlyCut) {
			goodBuzz--;
			badBuzz++;
			
			desc += "It was a very early cut of the movie, so reviews were harsh. ";
		}
		
		int delta = goodBuzz - badBuzz;
		if(delta > 2) {
			desc += "It was quite successful.";
		} 
		else if (delta < -2) {
			desc += "Reviews were disappointing...";
		}
		else {
			desc = "Reviews were mixed...";
		}

		return new ProductionEvent(goodBuzz, badBuzz, 0, desc, false);
	}
}