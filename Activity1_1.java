package session1;

public class Activity1_1 {

    public static void main(String[] args) {
	    // Object initialization
	    Car toyota = new Car();
		// Add default values
	    toyota.make = 2015;
	    toyota.color = "White";
	    toyota.transmission = "Manual";
	
		//Using Car class method
		toyota.displayCharacterstics();
		toyota.accelerate();
		toyota.brake();
    }

}