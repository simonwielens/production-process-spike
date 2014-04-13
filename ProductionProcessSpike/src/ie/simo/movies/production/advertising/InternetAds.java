package ie.simo.movies.production.advertising;

public class InternetAds extends Ad {
	
	private static final String INTERNET = "Internet Advertising";
	private static final String INTERNET_DESC = "Promotional website, youtube trailers, banner ads and social media... #hashtags";

	public InternetAds(){
		super(1, 5);
		setName(INTERNET);
		setDescription(INTERNET_DESC);
	}
}
