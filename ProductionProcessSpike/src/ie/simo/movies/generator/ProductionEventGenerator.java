package ie.simo.movies.generator;

import java.util.Random;

import ie.simo.movies.domain.MovieInfo;
import ie.simo.movies.production.AdType;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.util.RandomNumberProvider;

public class ProductionEventGenerator {
	private Random rng = RandomNumberProvider.getInstance();
	
	public ProductionEvent runAd(AdType type){
		return null;
	}
	
	public ProductionEvent communityChest(MovieInfo info){
		return null;
	}
	
	public ProductionEvent nextEvent(){
		
		ProductionEvent [] events = {
				new ProductionEvent(1, 5, -5, "Your sound engineer has accidentally appeared on 'To catch a predator'. Production has been delayed while you get a replacement", false),
				new ProductionEvent(1, 5, -10, "The star of your movie was pulled over for DUI and was jailed overnight. Production delayed while he arranges a lawyer.", false),
				new ProductionEvent(5, 5, 0, "Your director got into a twitter argument with Kanye West. No one wins", false),
				new ProductionEvent(0, 0, -15, "There was a fire at the special effects company's offices, and the work they did was destroyed and will have to be redone", false),
				new ProductionEvent(1, 5, -2, "An early draft of your script was leaked on the internet, and was mercilessly mocked.", false),
				new ProductionEvent(1, 5, -2, "An early cut of your movie was leaked, before special effects were added. It looks pretty ridiculous.", false),
				new ProductionEvent(1, 5, -2, "Your sound engineer has accidentally appeared on 'To catch a predator'. Production has been delayed while you get a replacement", false),
				new ProductionEvent(1, 5, -2, "Your sound engineer has accidentally appeared on 'To catch a predator'. Production has been delayed while you get a replacement", false)

		};
		
		return events[new Random().nextInt(events.length)];
	}
	
	//5% chance of getting an event
	public boolean isDueEvent(){
		return (rng.nextInt(100) <= 5);
	}

}
