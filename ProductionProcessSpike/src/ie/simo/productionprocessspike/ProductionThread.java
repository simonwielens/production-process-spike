package ie.simo.productionprocessspike;

import android.os.Bundle;
import android.os.Message;
import android.widget.ProgressBar;
import ie.simo.movies.production.CompletionStatusEvent;
import ie.simo.movies.production.ProductionEvent;
import ie.simo.movies.util.MMLogger;

public class ProductionThread implements Runnable {

	private Production production;
	private ProgressBar productionProgress;
	private static final String EFFECTS = "Good buzz changed by %d. Bad buzz changed by %d. ";

	public ProductionThread(Production production) {
		this.production = production;
		this.productionProgress = production.getProductionProgress();
	}

	public void handleEvent(ProductionEvent event) {
		Message m = Message.obtain(production.getHandler());
		Bundle b = new Bundle();
		b.putSerializable(Production.EVENT, event);
		m.setData(b);
		m.sendToTarget();
	}
	
	public void setPaused(boolean isPaused)
	{
		this.production.setPaused(isPaused);
	}
	
	public void handleProgress(int progress)
	{
		Message m = Message.obtain(production.getHandler());
		m.arg1 = progress;
		
		m.sendToTarget();
	}

	
	public void run() {
		
		while (productionProgress.getProgress() < 100) {
			if (!production.isPaused()) {
				try {
					Thread.sleep(100);
				
					if (productionProgress.getProgress() % 10 == 0) {
						handleEvent(new CompletionStatusEvent(productionProgress.getProgress()));
					}
					if (production.getEventGenerator().isDueEvent()) {
						handleEvent(production.getEventGenerator().nextEvent());
					}
					
					handleProgress(productionProgress.getProgress() + 1);
	
				}
				catch (Exception e) {
					MMLogger.e("ProductionThread", e.getMessage());
				}
			}
		}
	}
}