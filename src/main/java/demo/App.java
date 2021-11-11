package demo;
import com.jfinal.server.undertow.UndertowServer;

public class App {
	public static void main(String[] args) {
		UndertowServer.start(DemoConfig.class, 8080, true);
	}
}