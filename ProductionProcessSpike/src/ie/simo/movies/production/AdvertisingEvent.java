package ie.simo.movies.production;

import ie.simo.movies.production.advertising.Ad;

public class AdvertisingEvent extends ProductionEvent {
	
	private static final long serialVersionUID = 706465185225017632L;
	public static final String ADVERTISING_EVENT = "AdvertisingEvent";

	public AdvertisingEvent(Ad ad)
	{
		this.setType(ADVERTISING_EVENT);
		this.setBadBuzz(0);
		this.setGoodBuzz(ad.getEffect());
		this.setTitle("Advertising");
		this.setDescription("You have purchased advertising, good buzz has increased");
	}
}
