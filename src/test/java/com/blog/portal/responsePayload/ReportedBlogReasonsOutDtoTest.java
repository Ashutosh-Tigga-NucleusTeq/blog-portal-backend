package com.blog.portal.responsePayload;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ReportedBlogReasonsOutDtoTest {

    @Test
    public void testConstructorAndGetters() {
        List<String> reasons = new ArrayList<>();
        reasons.add("Reason 1");
        reasons.add("Reason 2");

        ReportedBlogReasonsOutDto outDto = new ReportedBlogReasonsOutDto(reasons);

        assertEquals(reasons, outDto.getReasons());
    }

    @Test
    public void testDefaultConstructor() {
        ReportedBlogReasonsOutDto outDto = new ReportedBlogReasonsOutDto();

        assertTrue(outDto.getReasons().isEmpty());
    }

    @Test
    public void testEqualsAndHashCode() {
        List<String> reasons1 = new ArrayList<>();
        reasons1.add("Reason 1");
        reasons1.add("Reason 2");
        ReportedBlogReasonsOutDto outDto1 = new ReportedBlogReasonsOutDto(reasons1);

        List<String> reasons2 = new ArrayList<>();
        reasons2.add("Reason 1");
        reasons2.add("Reason 2");
        ReportedBlogReasonsOutDto outDto2 = new ReportedBlogReasonsOutDto(reasons2);

        assertTrue(outDto1.equals(outDto2));
        assertEquals(outDto1.hashCode(), outDto2.hashCode());
    }

    @Test
    public void testNotEquals() {
        List<String> reasons1 = new ArrayList<>();
        reasons1.add("Reason 1");
        ReportedBlogReasonsOutDto outDto1 = new ReportedBlogReasonsOutDto(reasons1);

        List<String> reasons2 = new ArrayList<>();
        reasons2.add("Reason 2"); 
        ReportedBlogReasonsOutDto outDto2 = new ReportedBlogReasonsOutDto(reasons2);

        assertFalse(outDto1.equals(outDto2));
    }
}
