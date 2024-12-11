package com.discussion.forum.repository;


import com.discussion.forum.entities.Discussion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends MongoRepository<Discussion, String> {
}
