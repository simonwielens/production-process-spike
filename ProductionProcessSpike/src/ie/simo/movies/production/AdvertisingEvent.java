package ie.simo.movies.production;

import ie.simo.movies.production.advertising.Ad;

public class AdvertisingEvent extends ProductionEvent {
	public AdvertisingEvent(Ad ad)
	{
		this.setBadBuzz(0);
		this.setGoodBuzz(ad.getEffect());
		this.setTitle("Advertising");
		this.setDescription("You have purchased advertising, good buzz has increased");
	}
}
