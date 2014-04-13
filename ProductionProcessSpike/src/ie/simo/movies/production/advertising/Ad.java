package ie.simo.movies.production.advertising;

public abstract class Ad {
	private int cost;
	private int effect;
	private String description;
	private String name;
	
	public Ad(){}
	
	public Ad(int cost, int effect){
		this.cost = cost;
		this.effect = effect;
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public void reduceEffect(int count) {
		this.effect /= count;
		if(this.effect < 1) {
			this.effect = 1;
		}
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
