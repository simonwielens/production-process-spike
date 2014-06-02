package ie.simo.productionprocessspike;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;

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
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

@EActivity(R.layout.production)
public class Production extends ActivityWithMenu {

	public static final String EVENT = "event";

	@ViewById
	protected TextView totalGoodBuzz;
	
	@ViewById(R.id.releaseMovie)
	protected Button releaseMovieButton;

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
	protected void afterViews() {

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		releaseMovieButton.setVisibility(View.GONE);
		Iconify.addIcons(totalBadBuzz);
		Iconify.addIcons(totalGoodBuzz);
		adapter = new LazyAdapter(this, listItems);
		productionNews.setAdapter(adapter);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				ProductionEvent event = (ProductionEvent) msg.getData().get(
						EVENT);
				if (event != null && !event.isInteractive()) {
					listItems.add(0, event);

					goodBuzzCounter += event.getGoodBuzz();
					badBuzzCounter += event.getBadBuzz();
					adapter.notifyDataSetChanged();

					totalGoodBuzz
							.setText(goodBuzzCounter + " {fa-thumbs-o-up}");
					totalBadBuzz
							.setText(badBuzzCounter + " {fa-thumbs-o-down}");

					Iconify.addIcons(totalBadBuzz, totalGoodBuzz);
				}
				else if(event != null && event.isInteractive()){
					paused = true;
					new AlertDialog.Builder(getApplicationContext())
					.setTitle("Film Festival")
					.setMessage("You have been invited to submit your movie to a film festival. It could be a great way to promote the movie, but if it is to early in production it could lead to negative reviews...")
					.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							paused = false;
							dialog.cancel();
						}
					})
					.setPositiveButton("Yes Please", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//create event
							dialog.dismiss();
						}
					})
					.create().show();
				}

				int progress = msg.arg1;

				if (progress > 0 && progress <= 100) {
					progressText.setText("Production Progress: " + progress
							+ "%");
					productionProgress.setProgress(progress);
				}

			}
		};

		ProductionThread runnable = new ProductionThread(this);
		this.thread = runnable;

		startProduction();
	}

	@Click(R.id.advertiseBtn)
	protected void advertiseClick() {
		paused = true;
		Ad[] ads = { new Posters(), new InternetAds(), new Radio(),
				new TvAds(), new ViralAd() };
		new AdChoiceDialog(Production.this, Arrays.asList(ads), thread).show();
		adapter.notifyDataSetChanged();
	}

	@Click(R.id.screeningBtn)
	protected void screeningClick() {
		paused = true;

		View view = getLayoutInflater()
				.inflate(R.layout.screening_dialog, null);

		final EditText city = (EditText) view.findViewById(R.id.cityEditText);
		final RadioGroup group = (RadioGroup) view
				.findViewById(R.id.screeningRadioGroup);

		final AlertDialog ad = new AlertDialog.Builder(this)
				.setTitle("Arrange Screening")
				.setCancelable(true)
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								paused = false;
								dialog.cancel();
							}
						})
				.setPositiveButton("Arrange Screening",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								Message m = Message.obtain(handler);
								Bundle b = new Bundle();
								b.putSerializable(Production.EVENT,
										new ScreeningEvent(city.getText()
												.toString(), productionProgress.getProgress()));
								m.setData(b);
								m.sendToTarget();
								paused = false;
								dialog.dismiss();
							}
						}).setView(view).create();
		
		city.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}

			@Override
			public void afterTextChanged(Editable s) {
				if(s.toString().length() > 0)
				{
					ad.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
				}
			}
		});

		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.inCityRadioButton
						&& (city.getText().toString().equals(""))) {
					ad.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				} else {
					ad.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
				}
			}
		});

		ad.show();
		adapter.notifyDataSetChanged();
	}

	public void startProduction() {
		Thread t = new Thread(thread);
		t.start();
		
		//do nothing until it's finished
		while(t.isAlive()) {};
		
		releaseMovieButton.setVisibility(View.VISIBLE);
		
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
