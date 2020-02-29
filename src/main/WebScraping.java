package main;

import java.math.BigInteger;
import java.util.List;

public interface WebScraping {

	/**
	** @param url http address of an html file
	** @param outputFile of file to save to
	** @return a String containing the html body
	**/
	public void downloadFile(String url, String outputFile);

	/**
	** @param url valid url address
	** @return a SBigInteger value in bytes
	**/
	public BigInteger getFileSize(String url);

	/**
	** @param url valid url address
	** @return the name of the file
	**/
	public String getFileName(String url);

	/**
	** @param url valid url address
	** @return the extension of the file
	**/
	public String getFileExtension(String url);

	/**
	** @param url valid url address
	** @return true if is a link for a page with more content
	**/
	public boolean getIsLink(String url);

	/**
	** @param url http address of an html file
	** @return a String containing the html body
	**/
	public String getHtmlBody(String url);

	/**
	** @param htmlBody String containing the html body
	** @param startPos the start position for searching the tag
	** @return a String with the first ocurrence of the tag
	**/
	public String getElementByTag(String htmlBody, int startPos);

	/**
	** @param htmlBody String containing the html body or an element
	** @return a list of String all the tags on that page
	**/
	public List<String> getAllOcurrencesOfTag(String htmlBody);

	/**
	** @param element String containing the element html
	** @param startPos start position for the search
	** @return a String with the attribute
	**/
	public String getAttributeFromElement(String element, int startPos);

}