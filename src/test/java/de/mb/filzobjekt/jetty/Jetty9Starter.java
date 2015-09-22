package de.mb.filzobjekt.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Martin Burchard
 * 
 */
public class Jetty9Starter {

	private static final int HTTP_PORT = 8080;
	private static final int HTTPS_PORT = 443;
	private static final int SERVER_TIMEOUT = 120000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMaxThreads(500);
		final Server server = new Server(threadPool);
		final ServerConnector http = new ServerConnector(server);
		// http.setHost("localhost");
		http.setPort(HTTP_PORT);
		http.setIdleTimeout(SERVER_TIMEOUT);
		server.addConnector(http);

		final Resource keystore = Resource.newClassPathResource("/keystore");
		if (keystore != null && keystore.exists()) {
			// if a keystore for a SSL certificate is available, start a SSL
			// connector on port 8443.
			// By default, the quickstart comes with a Apache Wicket Quickstart
			// Certificate that expires about half way september 2021. Do not
			// use this certificate anywhere important as the passwords are
			// available in the source.

			final SslContextFactory factory = new SslContextFactory();
			factory.setKeyStoreResource(keystore);
			factory.setKeyStorePassword("wicket");
			factory.setTrustStoreResource(keystore);
			factory.setKeyManagerPassword("wicket");
			final ServerConnector https = new ServerConnector(server, factory);
			https.setIdleTimeout(SERVER_TIMEOUT);
			https.setPort(HTTPS_PORT);
			server.addConnector(https);

			System.out.println("SSL access to the quickstart has been enabled on port 8443");
			System.out.println("You can access the application using SSL on https://localhost:8443");
			System.out.println();
		}

		final WebAppContext bb = new WebAppContext();
		bb.addAliasCheck(new ContextHandler.ApproveAliases());
		bb.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
		bb.setServer(server);
		bb.setContextPath("/");
		bb.setWar("src/main/webapp");
		server.setHandler(bb);

		try {
			System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
			server.start();
			System.in.read();
			System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
			server.stop();
			server.join();
		} catch (final Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
