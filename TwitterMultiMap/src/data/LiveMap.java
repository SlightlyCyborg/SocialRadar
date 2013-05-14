package data;

import java.util.ArrayList;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.ScreenPosition;

public class LiveMap extends UnfoldingMap {

	ArrayList<Tweet> tweets;
	
	public LiveMap(PApplet parent, String s, float a, float b, float c, float d){
		super(parent,s, a,b,c,d);
		tweets = new ArrayList<Tweet>();
	}
	
	synchronized public void addTweet(Tweet tweet){
		tweets.add(tweet);
		tweet.setFade(20);
	}
	
	synchronized public void drawMe(){
		int x = 0;
		
		for (Tweet t: tweets){
			ScreenPosition pos = getScreenPosition(t.location);
			p.fill(176,28,31);
			p.stroke(0,0,0);
			x++;
			int f = t.fade();
			if (f > 0){
				p.ellipse(pos.x, pos.y, f, f);
				p.textSize(12);
				p.text(t.text, pos.x, pos.y + 50);
			}
		}
	}
	
	synchronized public void clearTweets(){
		tweets.clear();
	}
	
}
