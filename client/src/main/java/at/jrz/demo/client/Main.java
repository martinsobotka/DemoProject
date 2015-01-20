package at.jrz.demo.client;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {
    
    public static void main(String[] args) {
		if (args.length == 2) {
			try {
				CLIClient c = new CLIClient(args[0], Long.decode(args[1]));
				c.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			printHelp();
		}
    }

	private static void printHelp() {
		System.out.println("Usage: mcpiclient <service-uri> <number-of-data>");
	}
}
