package ie.simo.movies.production;

import java.io.Serializable;

public class ProductionEvent implements Serializable{

	private static final long serialVersionUID = 3503602765920927381L;
	// PR
	private int goodBuzz;
	private int badBuzz;
	private String type;
	// speed up or slow down production
	private int productionInfluence;
	private String title;
	// text desc of event
	private String description;
	private boolean interactive;

	public ProductionEvent() {
	}

	public ProductionEvent(int goodBuzz, int badBuzz, int influence,
			String description, boolean interactive) {
		this.setGoodBuzz(goodBuzz);
		this.setBadBuzz(badBuzz);
		this.setProductionInfluence(influence);
		this.setDescription(description);
		this.setInteractive(interactive);
	}

	public int getGoodBuzz() {
		return goodBuzz;
	}

	public void setGoodBuzz(int goodBuzz) {
		this.goodBuzz = goodBuzz;
	}

	public int getBadBuzz() {
		return badBuzz;
	}

	public void setBadBuzz(int badBuzz) {
		this.badBuzz = badBuzz;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductionInfluence() {
		return productionInfluence;
	}

	public void setProductionInfluence(int productionInfluence) {
		this.productionInfluence = productionInfluence;
	}

	public boolean isInteractive() {
		return interactive;
	}

	public void setInteractive(boolean interactive) {
		this.interactive = interactive;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
