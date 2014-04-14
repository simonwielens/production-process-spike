package ie.simo.movies.dialog;

import ie.simo.movies.adapter.AdvertisingAdapter;
import ie.simo.movies.adapter.LazyAdapter;
import ie.simo.movies.handler.AdHandler;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.production.advertising.Ad;
import ie.simo.productionprocessspike.ProductionThread;
import ie.simo.productionprocessspike.R;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class AdChoiceDialog extends Dialog{

	private Dialog dialog;
	private Button ok;
	private AdHandler adHandler;
	private ProductionThread thread;
	int selected;
	
	public AdChoiceDialog(Context context, final List<Ad> data, ProductionThread thread) {
		super(context);
		
		adHandler = new AdHandler(thread);
		dialog = this;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_advertising_dialog);
		Button cancel = (Button) this.findViewById(R.id.dialogButtonCancel);
		ok = (Button) this.findViewById(R.id.dialogButtonOK);
		ok.setEnabled(false);
		ListView list = (ListView) this.findViewById(R.id.adList);
		list.setAdapter(new AdvertisingAdapter(context, data));
		
		list.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> list, View view, int index,
					long arg3) {
				
				for (int j = 0; j < list.getChildCount(); j++)
				{
	                list.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
				}
				
				selected = index;
				view.setSelected(true);
				ok.setEnabled(true);
				view.setBackgroundColor(Color.CYAN);
			}
		});
		
		cancel.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				adHandler.put(data.get(selected));
				dialog.dismiss();
			}
		});
	}

}
