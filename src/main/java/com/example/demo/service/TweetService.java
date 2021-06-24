package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Repository;
import com.example.demo.repository.model.TweetDb;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TweetService {

	@Autowired
	private Repository repository;

	public List<TweetDb> getAllTweets() {
		return repository.findAll();
	}

	public TweetDb insertTweet(TweetDb tweet) {
		return repository.save(tweet);
	}

	public void showHomeTimeline(Twitter twitter) {

		List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();

			System.out.println("Showing home timeline.");

			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				String url = "https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId();
				System.out.println("Above tweet URL : " + url);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
