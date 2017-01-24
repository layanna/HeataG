import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.lang.Exception;


public class JFhem {
	public static void main(String[] args) throws Exception {
		String ipAddr = "CHANGE TO HOST OR IP"
		SocketAddress host = new InetSocketAddress(ipAddr, 7072);

		Socket sock = new Socket();

		sock.connect(host);

		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();

		out.write(new String("HELP\n").getBytes());
		while (true) {
			byte[] ans = new byte[200];
			in.read(ans);
			System.out.println(new String(ans));
		}
	}
}
