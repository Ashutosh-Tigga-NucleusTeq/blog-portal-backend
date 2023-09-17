package com.blog.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.ReportedPost;

@Repository
public interface ReportedPostRepo extends MongoRepository<ReportedPost, String> {

}
