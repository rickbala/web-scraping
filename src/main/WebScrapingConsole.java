package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class WebScrapingConsole {

	public static void main(String[] args) throws IOException {
		String indexUrl = "http://www.google.com/";
		downloadFile(indexUrl, "index.html");

		String fileUrl = indexUrl + "images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
		downloadFile(fileUrl, "logo.png"); //only for checking the size on the terminal

		BigInteger fileSize = getFileSize(fileUrl);
		System.out.println(fileSize);
	}

	private static void downloadFile(String url, String outFileName) throws IOException {
		URL website = new URL(url);
		ReadableByteChannel readableByteChannel = Channels.newChannel(website.openStream());
		FileOutputStream fileOutputStream = new FileOutputStream(outFileName);
		fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
		System.out.println("Downloaded file: " + outFileName);
	}

	private static BigInteger getFileSize(String urlString) throws MalformedURLException {
		URL url = new URL(urlString);
		HttpURLConnection httpURLConnection;
		BigInteger size = new BigInteger("0");

		try {
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			size = BigInteger.valueOf(httpURLConnection.getContentLength());
			httpURLConnection.getInputStream().close();
		} catch (Exception e) {
			System.out.println("Error while getting file info: " + urlString);
		}

		return size;
	}

}
