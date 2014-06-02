package ie.simo.movies.production;

public class FilmFestivalEvent extends ProductionEvent {
	
	private static final long serialVersionUID = 706465185225017632L;
	public static final String FESTIVAL_EVENT = "FilmFestivalEvent";
	
	public FilmFestivalEvent(String festivalDetails, int goodBuzz, int badBuzz)
	{
		this.setType(FESTIVAL_EVENT);
		this.setBadBuzz(badBuzz);
		this.setGoodBuzz(goodBuzz);
		this.setTitle("Film Festival");
		this.setDescription(festivalDetails);
	}
}