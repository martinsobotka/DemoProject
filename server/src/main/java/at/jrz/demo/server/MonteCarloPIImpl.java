package at.jrz.demo.server;

import at.jrz.demo.base.MonteCarloPI;
import at.jrz.demo.base.PIEntity;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Service implementation of MonteCarloPI interface
 * 
 * This implementation calculates/estimate the PI-Value using Monte-Carlo algorithm
 * 
 * @author martin
 */
public class MonteCarloPIImpl implements MonteCarloPI {

	@Override
	public PIEntity calculate(long numberOfRandomData) {
		Random rnd = new Random();
		PIEntity rv = new PIEntity();
		rv.setNumberOfData(numberOfRandomData);
		double inCircle = 0.0;
		double estimatedPI;
		
		// Start MonteCarlo-PI calculation
		long start = System.currentTimeMillis();
		for (int i = 0; i < numberOfRandomData; i++) {
			double x = rnd.nextDouble();
			double y = rnd.nextDouble();
			if (((x * x) + (y * y)) <= 1.0) {
				// count points which match x^2 + y^2 <= 1 --> m
				inCircle++;
			}
		}
		// PI = 4 * m/n
		estimatedPI = 4.0 * (inCircle / numberOfRandomData);
		rv.setEstimatedPI(estimatedPI);
		long end = System.currentTimeMillis();
		
		rv.setCalculationRuntime(end - start);
		return rv;
	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String info() {
		return "MonteCarloPIService REST Service";
	}
}
