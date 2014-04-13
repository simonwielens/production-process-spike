package ie.simo.productionprocessspike;

import android.widget.ProgressBar;
import ie.simo.movies.generator.ProductionEventGenerator;
import ie.simo.movies.production.CompletionStatusEvent;
import ie.simo.movies.production.ProductionEvent;

public class ProductionThread implements Runnable {
	
	protected ProductionEventGenerator eventGenerator;
	protected ProgressBar productionProgress;
	protected Production production;

	public void handleEvent(ProductionEvent event)
	{
		
	}
	
	@Override
	public void run() {
/*		
		final String effects = "Good buzz changed by %d. Bad buzz changed by %d. ";
		while (productionProgress.getProgress() < 100) {
			if(!production.isPaused())
			{
				try {
					Thread.sleep(100);
					productionProgress.setProgress(productionProgress.getProgress() + 1);
					production.getProgressText().setText("Production Progress: "+ productionProgress.getProgress() +"%");

					handler.post(new Runnable() {
						@Override
				        public void run() {
							if (productionProgress.getProgress() % 10 == 0) {
								listItems.add(0, new CompletionStatusEvent(productionProgress.getProgress()));
								adapter.notifyDataSetChanged();
							}
							if(eventGenerator.isDueEvent()){
								handle(eventGenerator.nextEvent());
							}
						}

						private void handle(ProductionEvent nextEvent) {
							listItems.add(0, nextEvent);
							adapter.notifyDataSetChanged();
						}
				    });
						
				} catch (Exception e) {
				}
			}
		}*/
	}
};