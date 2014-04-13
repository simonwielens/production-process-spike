package ie.simo.productionprocessspike;


import java.util.ArrayList;
import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

import ie.simo.movies.adapter.LazyAdapter;
import ie.simo.movies.dialog.AdChoiceDialog;
import ie.simo.movies.generator.ProductionEventGenerator;
import ie.simo.movies.production.CompletionStatusEvent;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.production.advertising.Ad;
import ie.simo.movies.production.advertising.InternetAds;
import ie.simo.movies.production.advertising.Posters;
import ie.simo.movies.production.advertising.Radio;
import ie.simo.movies.production.advertising.TvAds;
import ie.simo.movies.production.advertising.ViralAd;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

@Getter @Setter
public class Production extends ActivityWithMenu {

	private ProgressBar productionProgress;
	private TextView progressText;
	private ListView productionNews;
	private LazyAdapter adapter;
	private ArrayList<ProductionEvent> listItems = new ArrayList<ProductionEvent>();
	private Handler handler;
	private ProductionEventGenerator eventGenerator = new ProductionEventGenerator();
	private boolean paused = false;
	private Button advertise;
	private ProductionThread thread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.production);
		findAllViewsById();
		setButtonClickListeners(); 
		adapter = new LazyAdapter(this, listItems);
		productionNews.setAdapter(adapter);
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				adapter.notifyDataSetChanged();
			}
		};
		
		//TODO pass thread refererence to dialog
		
		ProductionThread runnable = new ProductionThread();
		this.thread = runnable;
		
		startProduction();
	}

	private void setButtonClickListeners() {
		advertise.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				paused = true;
				Ad[] ads = {new Posters(), new InternetAds(), new Radio(), new TvAds(), new ViralAd()};
				new AdChoiceDialog(Production.this, Arrays.asList(ads), listItems, adapter).show();
				paused = false;
				adapter.notifyDataSetChanged();
			}
		});
		
	}

	private void findAllViewsById() {
		productionProgress = (ProgressBar) findViewById(R.id.productionProgress);
		progressText = (TextView) findViewById(R.id.productionprogresstv);
		productionNews = (ListView) findViewById(android.R.id.list);
		advertise = (Button) findViewById(R.id.advertiseBtn);
	}

	private void updateList() {
		adapter.notifyDataSetChanged();
	}
	
	public void startProduction(){
		new Thread(thread).start();
	}
}

