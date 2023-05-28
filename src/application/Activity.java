package application;

public class Activity {
	
	private String name;
	private int calories=0;
	private double singleActivityHeartRate;
	private double heartRate;
	
	
	int newCalories(int calorieInc, int time)
	{
		return this.calories+=calorieInc*time;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getSingleActivityHeartRate() {
		return singleActivityHeartRate;
	}

	public void setSingleActivityHeartRate(double singleActivityHeartRate) {
		this.singleActivityHeartRate = singleActivityHeartRate;
	}

	public double getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(double heartRate) {
		this.heartRate = heartRate;
	}

}
