package ie.simo.movies.production;

public class CompletionStatusEvent extends ProductionEvent {

	private static final long serialVersionUID = 7331284017775329675L;

	public CompletionStatusEvent(int completionPercentage)
	{
		this.setBadBuzz(0);
		this.setGoodBuzz(0);
		this.setInteractive(false);
		this.setDescription("");
		this.setTitle("Production is now "+ completionPercentage +"% complete");
	}
}
