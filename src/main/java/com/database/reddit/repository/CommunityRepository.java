package com.database.reddit.repository;

import com.database.reddit.entity.Community;
import com.database.reddit.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community,Long> {

    @Query(value = "select  c from Community c where c.community_name = :name")
    Optional<Community> findCommunityByName(@Param("name") String name);
}
