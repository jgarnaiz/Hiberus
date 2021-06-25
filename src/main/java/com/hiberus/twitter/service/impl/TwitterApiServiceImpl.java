package com.hiberus.twitter.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hiberus.twitter.model.Tweet;
import com.hiberus.twitter.service.TwitterApiService;

import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Service
public class TwitterApiServiceImpl implements TwitterApiService {

	private static final int FOLLOWERS_LIMIT = 1500;
	private static final int CHARACTER_LIMIT = 280;
	private static final int HASHTAG_LIMIT = 10;

	/**
	 * Service to get tweets for authenticated user friends.
	 */
	@Override
	public List<Tweet> getTweets() throws Exception {

		Twitter twitter = new TwitterFactory().getInstance();

		List<Tweet> list = new ArrayList<>();
		try {

			twitter.getFriendsList(twitter.getId(), -1).stream()
					.filter(user -> user.getFollowersCount() > FOLLOWERS_LIMIT)
					.forEach(us -> addUserTweetsToList(twitter, us, list));

		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * add tweet from a user to response list.
	 * 
	 * @param twitter
	 * @param us
	 * @param list
	 */
	private void addUserTweetsToList(Twitter twitter, User us, List<Tweet> list) {
		try {
			twitter.getUserTimeline(us.getId()).stream().forEach(tw -> {
				Tweet tweet = new Tweet(us.getScreenName(), encode(tw.getText()), us.getLocation());
				list.add(tweet);
			});
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	/**
	 * utf-8 encoding.
	 * 
	 * @param text
	 * @return
	 */
	private String encode(String text) {

		String resp = new String(text.getBytes(), StandardCharsets.UTF_8);

		if (resp.length() > CHARACTER_LIMIT) {
			resp = resp.substring(0, CHARACTER_LIMIT);
		}
		return resp;
	}

	/**
	 * get trends by location.
	 */
	@Override
	public List<String> getTrendsByLocation(int code) {

		List<String> list = new ArrayList<>();

		try {
			Twitter twitter = new TwitterFactory().getInstance();

			list = Arrays.asList(twitter.getPlaceTrends(code).getTrends()).stream()
					.sorted(Comparator.comparing(Trend::getTweetVolume)).map(trend -> trend.getName())
					.collect(Collectors.toList());

			if (list.size() > HASHTAG_LIMIT) {
				list = list.subList(0, HASHTAG_LIMIT);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return list;
	}

}
