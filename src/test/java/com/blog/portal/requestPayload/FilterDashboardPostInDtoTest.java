package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.TechnologyCategory;


public class FilterDashboardPostInDtoTest {

	/**
	 * Instance of FilterDashboatdPostInDto.
	 */
    private FilterDashboardPostInDto filterDashboardPostInDto;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        filterDashboardPostInDto = new FilterDashboardPostInDto();
    }

    /**
     * Testing Getter and Setter.
     */
    @Test
    public void testGettersAndSetters() {
        // Test title getter and setter
        filterDashboardPostInDto.setTitle("Sample Title");
        assertEquals("Sample Title", filterDashboardPostInDto.getTitle());

        // Test techCategory getter and setter
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.Java);
        assertEquals(TechnologyCategory.Java, filterDashboardPostInDto.getTechCategory());

        // Test changing title and techCategory
        filterDashboardPostInDto.setTitle("Updated Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.Python);
        assertEquals("Updated Title", filterDashboardPostInDto.getTitle());
        assertEquals(TechnologyCategory.Python, filterDashboardPostInDto.getTechCategory());
    }

    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCode() {
        filterDashboardPostInDto.setTitle("Sample Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.Java);

        FilterDashboardPostInDto other = new FilterDashboardPostInDto();
        other.setTitle("Sample Title");
        other.setTechCategory(TechnologyCategory.Java);

        assertEquals(other.hashCode(), filterDashboardPostInDto.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        filterDashboardPostInDto.setTitle("Sample Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.Java);

        FilterDashboardPostInDto same = new FilterDashboardPostInDto();
        same.setTitle("Sample Title");
        same.setTechCategory(TechnologyCategory.Java);

        FilterDashboardPostInDto differentTitle = new FilterDashboardPostInDto();
        differentTitle.setTitle("Different Title");
        differentTitle.setTechCategory(TechnologyCategory.Java);

        FilterDashboardPostInDto differentTechCategory = new FilterDashboardPostInDto();
        differentTechCategory.setTitle("Sample Title");
        differentTechCategory.setTechCategory(TechnologyCategory.Python);

        assertTrue(filterDashboardPostInDto.equals(same));
        assertFalse(filterDashboardPostInDto.equals(differentTitle));
        assertFalse(filterDashboardPostInDto.equals(differentTechCategory));
        assertFalse(filterDashboardPostInDto.equals(null));
        assertFalse(filterDashboardPostInDto.equals("Not a FilterDashboardPostInDto"));
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        filterDashboardPostInDto.setTitle("Sample Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.Java);

        String expected = "FilterDashboardPostInDto [title=Sample Title, techCategory=Java]";
        assertEquals(expected, filterDashboardPostInDto.toString());
    }
}
