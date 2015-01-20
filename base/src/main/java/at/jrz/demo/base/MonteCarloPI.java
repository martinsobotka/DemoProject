package at.jrz.demo.base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * MonteCarlo PI Calculation
 * RESTful Service Interface
 * 
 * @author martin
 */
@Path("MonteCarloPI")
public interface MonteCarloPI {
	
	/**
	 * Generates/Calculates number PI by using Monte Carlo algorithm
	 * 
	 * @param numberOfRandomData - how many random generated values will be used for the calculation
	 * @return pi data object
	 */
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("calculate")
	public PIEntity calculate(
						@QueryParam("numberOfRandomData") long numberOfRandomData
					);
	
}
