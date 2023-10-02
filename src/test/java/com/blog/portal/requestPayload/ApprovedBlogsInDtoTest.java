package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.TechnologyCategory;


public class ApprovedBlogsInDtoTest {

	/**
	 * Instance of FilterDashboatdPostInDto.
	 */
    private ApprovedBlogsInDto approvedBlogsInDto;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        approvedBlogsInDto = new ApprovedBlogsInDto();
    }

    /**
     * Testing Getter and Setter.
     */
    @Test
    public void testGettersAndSetters() {
        approvedBlogsInDto.setTitle("Sample Title");
        assertEquals("Sample Title", approvedBlogsInDto.getTitle());

        approvedBlogsInDto.setTechCategory(TechnologyCategory.JAVA);
        assertEquals(TechnologyCategory.JAVA, approvedBlogsInDto.getTechCategory());

        approvedBlogsInDto.setTitle("Updated Title");
        approvedBlogsInDto.setTechCategory(TechnologyCategory.PYTHON);
        assertEquals("Updated Title", approvedBlogsInDto.getTitle());
        assertEquals(TechnologyCategory.PYTHON, approvedBlogsInDto.getTechCategory());
    }

    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCode() {
        approvedBlogsInDto.setTitle("Sample Title");
        approvedBlogsInDto.setTechCategory(TechnologyCategory.JAVA);

        ApprovedBlogsInDto other = new ApprovedBlogsInDto();
        other.setTitle("Sample Title");
        other.setTechCategory(TechnologyCategory.JAVA);

        assertEquals(other.hashCode(), approvedBlogsInDto.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        approvedBlogsInDto.setTitle("Sample Title");
        approvedBlogsInDto.setTechCategory(TechnologyCategory.JAVA);

        ApprovedBlogsInDto same = new ApprovedBlogsInDto();
        same.setTitle("Sample Title");
        same.setTechCategory(TechnologyCategory.JAVA);

        ApprovedBlogsInDto differentTitle = new ApprovedBlogsInDto();
        differentTitle.setTitle("Different Title");
        differentTitle.setTechCategory(TechnologyCategory.JAVA);

        ApprovedBlogsInDto differentTechCategory = new ApprovedBlogsInDto();
        differentTechCategory.setTitle("Sample Title");
        differentTechCategory.setTechCategory(TechnologyCategory.PYTHON);

        assertTrue(approvedBlogsInDto.equals(same));
        assertFalse(approvedBlogsInDto.equals(differentTitle));
        assertFalse(approvedBlogsInDto.equals(differentTechCategory));
        assertFalse(approvedBlogsInDto.equals(null));
        assertFalse(approvedBlogsInDto.equals("Not a ApprovedBlogsInDto"));
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        approvedBlogsInDto.setTitle("Sample Title");
        approvedBlogsInDto.setTechCategory(TechnologyCategory.JAVA);

        String expected = "ApprovedBlogsInDto [title=Sample Title, techCategory=JAVA]";
        assertEquals(expected, approvedBlogsInDto.toString());
    }
}
