package at.jrz.demo.base;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PI Transfer Object
 * 
 * @author martin
 */
@XmlRootElement
public class PIEntity implements Serializable {
	private double estimatedPI;
	private long numberOfRandomData;
	private long calculationRuntime;
	
	public PIEntity() {
	}
	
	public PIEntity(double estimatedPI, int numberOfRandomData, long calculationRuntime) {
		this.estimatedPI = estimatedPI;
		this.numberOfRandomData = numberOfRandomData;
		this.calculationRuntime = calculationRuntime;
	}

	public double getEstimatedPI() {
		return estimatedPI;
	}

	public void setEstimatedPI(double estimatedPI) {
		this.estimatedPI = estimatedPI;
	}

	public long getNumberOfData() {
		return numberOfRandomData;
	}

	public void setNumberOfData(long numberOfData) {
		this.numberOfRandomData = numberOfData;
	}

	public long getCalculationRuntime() {
		return calculationRuntime;
	}

	public void setCalculationRuntime(long calculationRuntime) {
		this.calculationRuntime = calculationRuntime;
	}

	@Override
	public String toString() {
		return "Estimated PI:               " + estimatedPI + "\n" +
			   "Deviation:                  " + String.format("%.15f", (estimatedPI - Math.PI)) + "\n" +
			   "Number of random data used: " + numberOfRandomData + "\n" +
			   "Calculation duration:       " + calculationRuntime + "ms\n";
	}
}
