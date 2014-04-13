package ie.simo.productionprocessspike;

import ie.simo.movies.domain.ProductionCompany;
import android.app.Activity;

public abstract class ActivityWithMenu extends Activity {
	
	private ProductionCompany pc;
 

	/**
	 * @return the current production company
	 */
	public ProductionCompany getPc() {
		return pc;
	}

	/**
	 * @param pc the production company to set
	 */
	public void setPc(ProductionCompany pc) {
		this.pc = pc;
	}
	
	public ActivityWithMenu(){
		super();
	}
}
