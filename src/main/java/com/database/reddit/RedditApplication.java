package com.database.reddit;

import com.database.reddit.entity.Community;
import com.database.reddit.entity.Post;
import com.database.reddit.entity.User;
import com.database.reddit.repository.CommunityRepository;
import com.database.reddit.repository.PostRepository;
import com.database.reddit.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class RedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			PostRepository postRepository,
			CommunityRepository communityRepository
	){
		return args -> {
			User user = userRepository.findById(1L).get();
//			System.out.println(userRepository.findB);

//			Community community = new Community();
//			community.setCommunity_name("My Community");
//			community.setAbout("About games");
//			community.setWiki("This is wiki");
//			community.setOwner(user);
//			community.setCommunityPeople(Set.of(user));
//			community.setCommunityPeople(Set.of(user));
//			Community save = communityRepository.save(community);
//			System.out.println(save.getId());
//			Post post = postRepository.findById(3L).get();
//			post.setCommunity(community);
//			postRepository.save(post);

//			Post post = new Post();
//			post.setTitle("first post in community");
//			post.setContent("Today doing something new");
//			Optional<User> byId = userRepository.findById(1L);
//			post.setUser(user);
//			post.set_community_post(true);
//			post.setCommunity_id(1L);
//			postRepository.save(post);

//			User user = new User();
//			user.setUsername("pankaj");
//			user.setEmail("pankaj@gmail.com");
//			userRepository.save(user);
//			System.out.println("done");
//			System.out.println(user.getOwnedCommunities());
//			Path path = Paths.get("./images");

//			Community c = communityRepository.findById(1L).get();
//			c.setCommunityModerators(Set.of(user));
//			communityRepository.save(c);

		};
	}

}
