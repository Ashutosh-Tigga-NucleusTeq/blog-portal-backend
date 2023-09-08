package com.example.demo.serviceimpl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.PostInDto;
import com.example.demo.dto.PostOutDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.PostService;

@Service
public class PostServiceImpl implements PostService {

		/**
		 * instance of PostRepo for performing operations
		 * on Post related data in database.
		 */
    @Autowired
    private PostRepo postRepo;

    /**
     * Instance of UserRepo for performing operations on
     * User related data in database.
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * Method that deal with creation of post API in database.
     */
    @Override
    public PostOutDto createPost(PostInDto postBlogInDto,
    		String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Post post = PostMapper.inDtoToPost(postBlogInDto);
        post.setAuthorId(user.getId());
        post.setCreatedAt(new Date());
        Post savedPost = this.postRepo.save(post);
        PostOutDto responseDto = PostMapper.postToOutDto(savedPost);
        return responseDto;
    }

}
