package ie.simo.movies.production.advertising;

public class Radio extends Ad {
	private static final String RADIO_DESC = "prime time radio advertising (right before Joe Duffy)";
	private static final String RADIO = "Radio Advertising";

	public Radio(){
		super(5, 10);
		setName(RADIO);
		setDescription(RADIO_DESC);
	}
}
