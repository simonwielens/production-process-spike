package ie.simo.movies.production.advertising;

import ie.simo.movies.util.RandomNumberProvider;

public class ViralAd extends Ad{
	private static final String VIRAL = "Viral Ad Campaign";
	private static final String VIRAL_DESC = "Hire a hip marketing company to try and produce a viral ad campaign. If it works, it can be the biggest available boost for interest. If it doesn't, you have thrown a lot of cash into a youtube video...";

	public ViralAd(){
		super(5, 0);
		setName(VIRAL);
		setDescription(VIRAL_DESC);
	}
	
	@Override
	public int getEffect() {
		return RandomNumberProvider.getInstance().nextInt(12);
	}
}
