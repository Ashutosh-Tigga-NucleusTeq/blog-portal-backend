package com.example.demo.serviceImpl;

import com.example.demo.dto.PostInDto;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.repository.PostRepo;
import com.example.demo.serviceimpl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

public class PostServiceImplTest {

	/**
	 * instance of PostRepo.
	 */
    @Mock
    private PostRepo postRepo;

    /**
     * instance of PostServiceImpl to be inject.
     */
    @InjectMocks
    private PostServiceImpl postService;

    /**
     * Setting up before invoking test.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * testing create post method of serviceImpl.
     */
    @Test
    public void testCreatePost() {
    	User user = new User();
    	user.setId("userid");
    	Date createdAt = new Date();

        // Prepare test data
        PostInDto postInDto = new PostInDto();
        postInDto.setTitle("title");
        postInDto.setContent("content");
    		postInDto.setCreatedAt(createdAt);
    		postInDto.setTechCategory(TechnologyCategory.Java);
    		postInDto.setAuthorId(user);

        Post savedPost = new Post();
        savedPost.setId("id");
        savedPost.setTitle("title");
        savedPost.setContent("content");
    		savedPost.setCreatedAt(createdAt);
    		savedPost.setTechCategory(TechnologyCategory.Java);
    		savedPost.setAuthorId(user);

        ApiResponse expectedApiResponse = new ApiResponse("Blog post created with id: id, title: title, content: content", true);

        // Mock the behavior of the postRepo.save() method
        when(postRepo.save(any(Post.class))).thenReturn(savedPost);

        // Call the method to be tested
        ApiResponse actualApiResponse = postService.createPost(postInDto);

        // Verify that the postRepo.save() method was called with the correct argument
        verify(postRepo, times(1)).save(any(Post.class));

        // Verify the actual response matches the expected response
        assertEquals(expectedApiResponse.getMessage(), actualApiResponse.getMessage());
        assertEquals(expectedApiResponse.isSuccess(), actualApiResponse.isSuccess());
    }
}
