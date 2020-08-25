package JavaActivity2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>();
	}

	public void onboard(String passenger) {
		this.passengers.add(passenger);
	}

	public Date takeOff() {
		this.lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}

	public void land() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassengers() {
		return passengers;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}
}

public class Activity2_2 {
	public static void main(String[] params) {
		Plane plane = new Plane(10);
		plane.onboard("John");
		plane.onboard("Steve");
		plane.onboard("Anna");
		System.out.println("Plane took off at: " + plane.takeOff());
		System.out.println("People on the plane: " + plane.getPassengers());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		plane.land();
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: " + plane.getPassengers());
	}
}