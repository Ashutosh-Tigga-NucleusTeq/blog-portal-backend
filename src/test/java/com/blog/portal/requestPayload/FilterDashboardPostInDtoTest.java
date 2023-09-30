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
        filterDashboardPostInDto.setTitle("Sample Title");
        assertEquals("Sample Title", filterDashboardPostInDto.getTitle());

        filterDashboardPostInDto.setTechCategory(TechnologyCategory.JAVA);
        assertEquals(TechnologyCategory.JAVA, filterDashboardPostInDto.getTechCategory());

        filterDashboardPostInDto.setTitle("Updated Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.PYTHON);
        assertEquals("Updated Title", filterDashboardPostInDto.getTitle());
        assertEquals(TechnologyCategory.PYTHON, filterDashboardPostInDto.getTechCategory());
    }

    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCode() {
        filterDashboardPostInDto.setTitle("Sample Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.JAVA);

        FilterDashboardPostInDto other = new FilterDashboardPostInDto();
        other.setTitle("Sample Title");
        other.setTechCategory(TechnologyCategory.JAVA);

        assertEquals(other.hashCode(), filterDashboardPostInDto.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        filterDashboardPostInDto.setTitle("Sample Title");
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.JAVA);

        FilterDashboardPostInDto same = new FilterDashboardPostInDto();
        same.setTitle("Sample Title");
        same.setTechCategory(TechnologyCategory.JAVA);

        FilterDashboardPostInDto differentTitle = new FilterDashboardPostInDto();
        differentTitle.setTitle("Different Title");
        differentTitle.setTechCategory(TechnologyCategory.JAVA);

        FilterDashboardPostInDto differentTechCategory = new FilterDashboardPostInDto();
        differentTechCategory.setTitle("Sample Title");
        differentTechCategory.setTechCategory(TechnologyCategory.PYTHON);

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
        filterDashboardPostInDto.setTechCategory(TechnologyCategory.JAVA);

        String expected = "FilterDashboardPostInDto [title=Sample Title, techCategory=JAVA]";
        assertEquals(expected, filterDashboardPostInDto.toString());
    }
}
