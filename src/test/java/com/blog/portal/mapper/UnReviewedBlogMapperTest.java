package com.blog.portal.mapper;

import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.UnReviewedBlogsOutDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class UnReviewedBlogMapperTest {

    private Blog createMockPost() {
        Blog blog = new Blog();
        blog.setId("123");
        blog.setTitle("Sample Title");
        blog.setContent("Sample Content");
        blog.setCreatedAt(new Date(12));
        blog.setTechCategory(TechnologyCategory.JAVA);

        User user = new User();
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setDesignation(Designation.INTERN);
        blog.setUser(user);

        return blog;
    }

    @Test
    public void testEntityToOutDto() {
        Blog blog = createMockPost();

        UnReviewedBlogsOutDto outDto = UnReviewedBlogMapper.entityToOutDto(blog);

        assertEquals("firstname lastname", outDto.getUserName());
        assertEquals("123", outDto.getId());
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals("Sample Content", outDto.getContent());
        assertEquals(new Date(12), outDto.getCreatedAt());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechCategory());
        assertEquals(Designation.INTERN, outDto.getUserDesignation());
    }
}
