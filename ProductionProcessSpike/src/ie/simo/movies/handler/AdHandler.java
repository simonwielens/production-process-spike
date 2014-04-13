package ie.simo.movies.handler;

import ie.simo.movies.adapter.LazyAdapter;
import ie.simo.movies.production.AdvertisingEvent;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.production.advertising.Ad;

import java.util.List;

import android.widget.Adapter;

public class AdHandler {

	private List<ProductionEvent> events;
	private LazyAdapter adapter;
	
	public AdHandler(List<ProductionEvent> events, LazyAdapter adapter)
	{
		this.events = events;
		this.adapter = adapter;
	}
	
	public void put(Ad ad)
	{
		events.add(0, new AdvertisingEvent(ad));
		adapter.notifyDataSetChanged();
	}
}
