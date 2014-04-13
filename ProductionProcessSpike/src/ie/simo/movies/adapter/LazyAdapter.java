package ie.simo.movies.adapter;

import ie.simo.movies.image.ImageFactory;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.productionprocessspike.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
	 
    private Activity activity;
    private ArrayList<ProductionEvent> data;
    private static LayoutInflater inflater=null;
    public ImageFactory factory;
 
    public LazyAdapter(Activity a, ArrayList<ProductionEvent> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        factory = new ImageFactory(activity.getApplicationContext());
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView comment = (TextView)vi.findViewById(R.id.comment); // artist name
        TextView goodBuzz = (TextView)vi.findViewById(R.id.goodBuzz); // duration
        TextView badBuzz = (TextView)vi.findViewById(R.id.badBuzz); // duration
        ImageView thumb_image =(ImageView)vi.findViewById(R.id.list_image); // thumb image
 
        ProductionEvent event = data.get(position);
 
        // Setting all values in listview
        title.setText(event.getTitle());
        comment.setText(event.getDescription());
        goodBuzz.setText(event.getGoodBuzz() + "");
        badBuzz.setText(event.getBadBuzz() + "");
        thumb_image.setImageDrawable(factory.getImage(event.getTitle()));
        return vi;
    }
}
