package ie.simo.movies.image;

import ie.simo.productionprocessspike.R;
import android.content.Context;
import android.graphics.drawable.Drawable;

public class ImageFactory {
	private Context context;
	
	public ImageFactory(Context context){
		this.context = context;
	}
	
	public Drawable getImage(String type){
		int id;
		
		if(type != null && type.equalsIgnoreCase("AdvertisingEvent")){
			id = R.drawable.ad;
		}
		else {
			id = R.drawable.camera;
		}
		
		Drawable d = context.getResources().getDrawable(id); 
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight()); 
        return d;
	}
}
