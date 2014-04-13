package ie.simo.movies.handler;

import ie.simo.movies.production.AdvertisingEvent;
import ie.simo.movies.production.advertising.Ad;
import ie.simo.productionprocessspike.ProductionThread;

public class AdHandler {

	private ProductionThread thread;
	
	public AdHandler(ProductionThread thread)
	{
		this.thread = thread;
	}
	
	public void put(Ad ad)
	{
		thread.handleEvent(new AdvertisingEvent(ad));
	}
}
