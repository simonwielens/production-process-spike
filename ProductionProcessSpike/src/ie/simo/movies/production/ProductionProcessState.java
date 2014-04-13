package ie.simo.movies.production;

import java.util.List;

public class ProductionProcessState {
	
	private int percentComplete;
	private List<ProductionEvent> events;
	private int goodBuzz;
	private int badBuzz;
	public static final int MAX_COMPLETE = 100;
	public static final int MIN_COMPLETE = 0;
	
	
	public List<ProductionEvent> getEvents() {
		return events;
	}
	public void setEvents(List<ProductionEvent> events) {
		this.events = events;
	}
	public int getGoodBuzz() {
		return goodBuzz;
	}
	public void setGoodBuzz(int goodBuzz) {
		this.goodBuzz = goodBuzz;
	}
	public int getBadBuzz() {
		return badBuzz;
	}
	public void setBadBuzz(int badBuzz) {
		this.badBuzz = badBuzz;
	}
		
	public int getPercentComplete() {
		return percentComplete;
	}
	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}
	
	public void increment(int i) {
		percentComplete += i;
		if(percentComplete > MAX_COMPLETE){
			percentComplete = MAX_COMPLETE;
		}
		if(percentComplete < MIN_COMPLETE){
			percentComplete = MIN_COMPLETE;
		}
	}
	public boolean isComplete() {
		return (percentComplete == MAX_COMPLETE);
	}
	

}
