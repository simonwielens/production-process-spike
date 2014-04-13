package ie.simo.movies.production.advertising;

import java.util.HashMap;

public class AdFactory {
	
	private HashMap<String, Integer> alreadyUsed = new HashMap<String, Integer>();
	
	public Ad createAd(String adType){
		Ad theAd;
		if("Internet".equals(adType)){
			theAd = new InternetAds();	
		}
		else if("Posters".equals(adType)){
			theAd = new Posters();	
		}
		else if("Radio".equals(adType)){
			theAd = new Radio();	
		}
		else if("Tv".equals(adType)){
			theAd = new TvAds();	
		}
		else{
			theAd = new ViralAd();
		}
		
		int count = (alreadyUsed.get(adType) == null) ? 1 : alreadyUsed.get(adType) + 1;
		alreadyUsed.put(adType, count);
		
		theAd.reduceEffect(count);
		
		return theAd;
	}

}
