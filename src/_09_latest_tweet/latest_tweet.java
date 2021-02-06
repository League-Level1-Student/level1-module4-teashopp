package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class latest_tweet implements ActionListener {
	
	static JFrame frame = new JFrame("The Amazing Tweet Retriever");
	static JButton button = new JButton("Search the Twitterverse!");
	static JTextArea ta = new JTextArea();

	public static void main(String[] args) {

		button.setBounds(250, 100, 200, 60);
		
		latest_tweet lt = new latest_tweet();
		lt.addactionlistener();
		
		ta.setBounds(50, 100, 150, 60);
			
		frame.add(button);
		frame.add(ta);
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	private String getLatestTweet(String searchingFor) {

		Twitter twitter = new TwitterFactory().getInstance();

		AccessToken accessToken = new AccessToken("2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
				"vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
		twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN", "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
		twitter.setOAuthAccessToken(accessToken);

		Query query = new Query(searchingFor);
		try {
			QueryResult result = twitter.search(query);
			return result.getTweets().get(0).getText();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return "What the heck is that?";
		}
		
	}
	
	public void addactionlistener() {
		
		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		getLatestTweet(null);
		
	}

}
