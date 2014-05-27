package ie.simo.movies.production;

import java.util.Random;

import ie.simo.movies.util.RandomNumberProvider;

public class ScreeningEvent extends ProductionEvent {
	
	private static final long serialVersionUID = 706465185225017632L;
	public static final String SCREENING_EVENT = "ScreeningEvent";
	private Random rng = RandomNumberProvider.getInstance();

	public ScreeningEvent(String location)
	{
		this.setType(SCREENING_EVENT);
		ProductionEvent event = createScreening(location);
		this.setBadBuzz(event.getBadBuzz());
		this.setGoodBuzz(event.getGoodBuzz());
		this.setTitle("Screening");
		this.setDescription(event.getDescription());
	}
	
	public ProductionEvent createScreening(String location) {
		int goodBuzz = rng.nextInt(7);
		int badBuzz = rng.nextInt(7);
		
		int delta = goodBuzz - badBuzz;
		String desc = "";
		if(delta > 2) {
			desc =  "You held a screening in " + location + ". It was quite successful.";
		} 
		else if (delta < -2) {
			desc =  "You held a screening in " + location + ". Reviews were disappointing...";
		}
		else {
			desc =  "You held a screening in " + location + ". Reviews were mixed...";
		}

		return new ProductionEvent(goodBuzz, badBuzz, 0, desc, false);
	}
}