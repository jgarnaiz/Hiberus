package com.hiberus.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.twitter.repository.Repository;
import com.hiberus.twitter.repository.model.TweetDb;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

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

	public void showHomeTimeline() throws Exception {

		System.out.println("Creando twitter...");
		Twitter twitter = new TwitterFactory().getInstance();
		System.out.println("Configurando twitter...");
//		twitter.setOAuthConsumer("CZjfwQDYrZoci1IQeJtmbsJRJ", "rxAYvAE45Y2keeukYE40nMsQmVxY3yMlROg6NjiZ4qd38KEluL");
//		twitter.setOAuthAccessToken(new AccessToken(
//				"AAAAAAAAAAAAAAAAAAAAAB3nQwEAAAAAHiVp32X3TKbRirLEKjMcVo9rGhs%3DBZkM12CYL7vH1w5456aBdsEAV9TTKLpKv07vK4z57Y4EsmBHsV",
//				"ymmds1T71YFEmfKYXpva6Trazbp6OFOV9X31COqikh44L"));

		System.out.println("Creado twitter!");

		User usuario = twitter.verifyCredentials();
		System.out.println("Nombre: " + usuario.getName());
		System.out.println("Descripcion: " + usuario.getDescription());
		System.out.println("Id Usuario: " + usuario.getId());
		System.out.println("Número Seguidores: " + usuario.getFollowersCount());

		List<Status> statuses = null;
		try {
			statuses = twitter.getUserTimeline("@TraedRuffles");

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
