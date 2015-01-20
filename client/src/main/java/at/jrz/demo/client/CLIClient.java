package at.jrz.demo.client;


import at.jrz.demo.base.MonteCarloPI;
import at.jrz.demo.base.PIEntity;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

/**
 *
 * @author martin
 */
public class CLIClient implements Runnable {
	
	private final String _serviceURI;
	private final long _numberOfData;
	
	public CLIClient(String serviceURI, long numberOfData) {
		_serviceURI = serviceURI;
		_numberOfData = numberOfData;
	}

	@Override
	public void run() {
		MonteCarloPI service = JAXRSClientFactory.create(_serviceURI, MonteCarloPI.class);
		PIEntity pi = service.calculate(_numberOfData);
		System.out.println(pi);
	}
	
}
