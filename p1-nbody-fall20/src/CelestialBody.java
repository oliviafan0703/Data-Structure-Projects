

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
	}

	public double getX() {
		// TODO: complete method
		return 0.0;
	}
	public double getY() {
		// TODO: complete method
		return 0.0;
	}
	public double getXVel() {
		// TODO: complete method
		return 0.0;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return 0.0;
	}
	
	public double getMass() {
		// TODO: complete method
		return 0.0;
	}
	public String getName() {
		// TODO: complete method
		return "cow planet";
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
