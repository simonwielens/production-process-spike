package ie.simo.productionprocessspike;


import java.util.ArrayList;
import java.util.Arrays;

import ie.simo.movies.adapter.LazyAdapter;
import ie.simo.movies.dialog.AdChoiceDialog;
import ie.simo.movies.generator.ProductionEventGenerator;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.production.advertising.Ad;
import ie.simo.movies.production.advertising.InternetAds;
import ie.simo.movies.production.advertising.Posters;
import ie.simo.movies.production.advertising.Radio;
import ie.simo.movies.production.advertising.TvAds;
import ie.simo.movies.production.advertising.ViralAd;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Production extends ActivityWithMenu {
	
	public static final String EVENT = "event";

	private ProgressBar productionProgress;
	private TextView progressText;
	private ListView productionNews;
	private LazyAdapter adapter;
	private ArrayList<ProductionEvent> listItems = new ArrayList<ProductionEvent>();
	private static Handler handler;
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
				ProductionEvent event = (ProductionEvent) msg.getData().get(EVENT);
				if(event != null)
				{
					listItems.add(0, event);
					adapter.notifyDataSetChanged();
				}
				
				int progress = msg.arg1;
				
				if(progress > 0 && progress <= 100)
				{
					progressText.setText("Production Progress: "
							+ progress + "%");
					productionProgress.setProgress(progress);
				}
				
			}
		};
		
		ProductionThread runnable = new ProductionThread(this);
		this.thread = runnable;
		
		startProduction();
	}

	private void setButtonClickListeners() {
		advertise.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				paused = true;
				Ad[] ads = {new Posters(), new InternetAds(), new Radio(), new TvAds(), new ViralAd()};
				new AdChoiceDialog(Production.this, Arrays.asList(ads), thread).show();
				paused = false;
				adapter.notifyDataSetChanged();
			}
		});
		
	}

	private void findAllViewsById() {
		setProductionProgress((ProgressBar) findViewById(R.id.productionProgress));
		progressText = (TextView) findViewById(R.id.productionprogresstv);
		productionNews = (ListView) findViewById(android.R.id.list);
		advertise = (Button) findViewById(R.id.advertiseBtn);
	}
	
	public void startProduction(){
		new Thread(thread).start();
	}

	public ProgressBar getProductionProgress() {
		return productionProgress;
	}

	public void setProductionProgress(ProgressBar productionProgress) {
		this.productionProgress = productionProgress;
	}
	public TextView getProgressText() {
		return progressText;
	}

	public void setProgressText(TextView progressText) {
		this.progressText = progressText;
	}

	public ListView getProductionNews() {
		return productionNews;
	}

	public void setProductionNews(ListView productionNews) {
		this.productionNews = productionNews;
	}

	public LazyAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(LazyAdapter adapter) {
		this.adapter = adapter;
	}

	public ArrayList<ProductionEvent> getListItems() {
		return listItems;
	}

	public void setListItems(ArrayList<ProductionEvent> listItems) {
		this.listItems = listItems;
	}

	public Handler getHandler() {
		return handler;
	}

	public ProductionEventGenerator getEventGenerator() {
		return eventGenerator;
	}

	public void setEventGenerator(ProductionEventGenerator eventGenerator) {
		this.eventGenerator = eventGenerator;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public Button getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Button advertise) {
		this.advertise = advertise;
	}

	public ProductionThread getThread() {
		return thread;
	}

	public void setThread(ProductionThread thread) {
		this.thread = thread;
	}
}

