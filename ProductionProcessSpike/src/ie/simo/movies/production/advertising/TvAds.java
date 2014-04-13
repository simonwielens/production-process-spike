package ie.simo.movies.production.advertising;

public class TvAds extends Ad{
	private static final String TV_AD = "TV Ad";
	private static final String TV_DESC = "Primetime tv advertising, suitable for your movie's genre";

	public TvAds(){
		super(8, 15);
		setName(TV_AD);
		setDescription(TV_DESC);
	}
}
