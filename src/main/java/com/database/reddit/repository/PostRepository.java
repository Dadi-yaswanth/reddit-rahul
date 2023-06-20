package com.database.reddit.repository;

import com.database.reddit.entity.Community;
import com.database.reddit.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "select p from Post p join p.community c where c.community_name = :name and p.postId = :postId")
    Optional<Post> findPostsByCommunityName(@Param("name") String communityName,
                                                 @Param("postId")Long postId);
}
