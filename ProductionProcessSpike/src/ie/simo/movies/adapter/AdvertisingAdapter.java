package ie.simo.movies.adapter;

import ie.simo.movies.production.advertising.Ad;
import ie.simo.productionprocessspike.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdvertisingAdapter extends BaseAdapter {
	 
    private List<Ad> data;
    private static LayoutInflater inflater=null;
 
    public AdvertisingAdapter(Context context, List<Ad> d) {
        data=d;
        inflater = LayoutInflater.from(context);
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
            vi = inflater.inflate(R.layout.ad_desc_list_row, null);
 
        TextView adCategory = (TextView)vi.findViewById(R.id.ad_category); 
        TextView adDesc = (TextView)vi.findViewById(R.id.ad_desc); 
        TextView adCost = (TextView)vi.findViewById(R.id.ad_cost);
 
        Ad ad = data.get(position);
 
        // Setting all values in listview
        adCategory.setText(ad.getName());
        adDesc.setText(ad.getDescription());
        adCost.setText("$"+ad.getCost() + "M");
        
        return vi;
    }
}