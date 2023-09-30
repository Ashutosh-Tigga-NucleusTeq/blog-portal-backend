package com.blog.portal.requestPayload;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.blog.portal.enumResource.TechnologyCategory;

public class PostBlogInDtoTest {

	/**
	 * Instance of PostBlogInDto.
	 */
    private PostBlogInDto post;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        post = new PostBlogInDto("Sample Title", "Sample Content", new Date(), "sampleUserId", TechnologyCategory.JAVA);
        post.setId("sampleId");
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        assertEquals("sampleId", post.getId());
        assertEquals("Sample Title", post.getTitle());
        assertEquals("Sample Content", post.getContent());
        assertNotNull(post.getCreatedAt());
        assertEquals("sampleUserId", post.getUserId());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());

        post.setId("newId");
        post.setTitle("New Title");
        post.setContent("New Content");
        post.setCreatedAt(new Date());
        post.setUserID("newUserId");
        post.setTechCategory(TechnologyCategory.HTML);

        assertEquals("newId", post.getId());
        assertEquals("New Title", post.getTitle());
        assertEquals("New Content", post.getContent());
        assertNotNull(post.getCreatedAt());
        assertEquals("newUserId", post.getUserId());
        assertEquals(TechnologyCategory.HTML, post.getTechCategory());
    }

    /**
     * Testing hashcode and equals.
     */
    @Test
    public void testHashCodeAndEquals() {
        PostBlogInDto samePost = new PostBlogInDto("Sample Title", "Sample Content",
        		new Date(), "sampleUserId", TechnologyCategory.JAVA);
        samePost.setId("sampleId");

        assertEquals(post.hashCode(), samePost.hashCode());
        assertEquals(post, post);
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        String expectedToString = "PostBlogInDto [id=sampleId,"
        		+ " title=Sample Title, content=Sample Content, createdAt="
        		+ post.getCreatedAt() + ", userId=sampleUserId, techCategory=JAVA]";
        assertEquals(expectedToString, post.toString());
    }
}
