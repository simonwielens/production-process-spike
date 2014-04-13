package ie.simo.movies.production.advertising;

public class Posters extends Ad {
	private static final String POSTERS = "Posters and Billboards";
	private static final String POSTERS_DESC = "A poster campaign around all of the major cities where your movie will hopefully be shown! The cheapest form of advertising to get people talking, but limited impact.";

	public Posters() {
		super(2, 7);
		setName(POSTERS);
		setDescription(POSTERS_DESC);
	}
}
