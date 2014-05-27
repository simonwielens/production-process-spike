package ie.simo.productionprocessspike;

import java.util.ArrayList;
import java.util.Arrays;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.joanzapata.android.iconify.Iconify;

import ie.simo.movies.adapter.LazyAdapter;
import ie.simo.movies.dialog.AdChoiceDialog;
import ie.simo.movies.generator.ProductionEventGenerator;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.production.ScreeningEvent;
import ie.simo.movies.production.advertising.Ad;
import ie.simo.movies.production.advertising.InternetAds;
import ie.simo.movies.production.advertising.Posters;
import ie.simo.movies.production.advertising.Radio;
import ie.simo.movies.production.advertising.TvAds;
import ie.simo.movies.production.advertising.ViralAd;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

@EActivity(R.layout.production)
public class Production extends ActivityWithMenu {
	
	public static final String EVENT = "event";
	
	@ViewById
	protected TextView totalGoodBuzz;
	
	@ViewById
	protected TextView totalBadBuzz;
	
	@ViewById
	protected ProgressBar productionProgress;
	
	@ViewById(value = R.id.productionprogresstv)
	protected TextView progressText;
	
	@ViewById(value = android.R.id.list)
	protected ListView productionNews;
	
	@ViewById(value = R.id.advertiseBtn)
	protected Button advertise;
	
	@ViewById(value = R.id.screeningBtn)
	protected Button screening;
	
	private LazyAdapter adapter;
	private ArrayList<ProductionEvent> listItems = new ArrayList<ProductionEvent>();
	private static Handler handler;
	private ProductionEventGenerator eventGenerator = new ProductionEventGenerator();
	private boolean paused = false;
	
	int goodBuzzCounter;
	int badBuzzCounter;
	
	private ProductionThread thread;
	
	@AfterViews
	protected void afterViews(){
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Iconify.addIcons(totalBadBuzz);
		Iconify.addIcons(totalGoodBuzz);
		adapter = new LazyAdapter(this, listItems);
		productionNews.setAdapter(adapter);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				ProductionEvent event = (ProductionEvent) msg.getData().get(EVENT);
				if(event != null)
				{
					listItems.add(0, event);
					
					goodBuzzCounter += event.getGoodBuzz();
					badBuzzCounter += event.getBadBuzz();
					adapter.notifyDataSetChanged();
					
					totalGoodBuzz.setText(goodBuzzCounter + " {fa-thumbs-o-up}");
					totalBadBuzz.setText(badBuzzCounter + " {fa-thumbs-o-down}");
					
					Iconify.addIcons(totalBadBuzz, totalGoodBuzz);
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
	
	@Click (R.id.advertiseBtn)
	protected void advertiseClick(){
		paused = true;
		Ad[] ads = {new Posters(), new InternetAds(), new Radio(), new TvAds(), new ViralAd()};
		new AdChoiceDialog(Production.this, Arrays.asList(ads), thread).show();
		adapter.notifyDataSetChanged();
	}
	
	@Click (R.id.screeningBtn)
	protected void screeningClick(){
		paused = true;
		new AlertDialog.Builder(this)
			.setTitle("Arrange Screening")
			.setMessage("Choose where to hold the screening")
			.setCancelable(true)
			.setNeutralButton("On Studio Lot", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Message m = Message.obtain(handler);
					Bundle b = new Bundle();
					b.putSerializable(Production.EVENT, new ScreeningEvent("the studio lot"));
					m.setData(b);
					m.sendToTarget();
					dialog.dismiss();
				}
			})
			.setPositiveButton("In A City", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Message m = Message.obtain(handler);
					Bundle b = new Bundle();
					b.putSerializable(Production.EVENT, new ScreeningEvent("London"));
					m.setData(b);
					m.sendToTarget();
					dialog.dismiss();
				}
			}).create().show();
		paused = false;
		adapter.notifyDataSetChanged();
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

