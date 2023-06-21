package com.database.reddit.service;

import com.database.reddit.Dto.PostDto;
import com.database.reddit.entity.Community;
import com.database.reddit.entity.Media;
import com.database.reddit.entity.Post;
import com.database.reddit.entity.User;
import com.database.reddit.repository.CommunityRepository;
import com.database.reddit.repository.PostRepository;
import com.database.reddit.repository.UserRepository;
import jakarta.transaction.NotSupportedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostRepository postRepository;
    private final FileServiceImpl fileService;
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;

    public Post viewPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    public Post savePost(PostDto postDto, MultipartFile[] file) throws IOException, NotSupportedException {
        Post post = new Post();
        User user = userRepository.findById(1L).orElseThrow();
        post.setUser(user);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        List<Media> mediaList = new ArrayList<>();
//        post.setIsCommunity(true);
//        Community community = communityRepository.findById(1L).get();
//        post.setCommunity(community);

        if (file != null) {
            for (MultipartFile multipartFile : file) {
                Media media = fileService.uploadImage(multipartFile);
                System.out.println(media);
                System.out.println(media.getMediaId());
                mediaList.add(media);
            }
        }

        post.setMediaList(mediaList);
        return postRepository.save(post);
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId).get();
    }

    public Post getPostByType(String typeOfAccount, String username, Long postId) {
        if (typeOfAccount.equalsIgnoreCase("r")) {
            return postRepository.findPostsByCommunityName(username, postId).orElseThrow();
        }
        else if(typeOfAccount.equalsIgnoreCase("u")){
            System.out.println("user");
            return postRepository.findPostsByUsername(username, postId).orElseThrow();
        }
        return null;
    }
}
