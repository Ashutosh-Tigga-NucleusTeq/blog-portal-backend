package com.blog.portal.responsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class Represent Response Dto that contains Reported Blog resons of particular selected Blog.
 *
 * @author [ Ashutosh Tigga]
 */
public class ReportedBlogReasonsOutDto {
	/**
	 * Reason of reporting on particular post.
	 */
	private List<String> reasons = new ArrayList<String>();

	/**
	 * String representation of {@code ReportedBlogReasonsOutDto}.
	 */
	@Override
	public String toString() {
		return "ReportedBlogReasonsOutDto [reasons=" + reasons + "]";
	}

	/**
	 * Parameterized constructor.
	 *
	 * @param reasons
	 */
	public ReportedBlogReasonsOutDto(final List<String> reasons) {
		super();
		this.reasons = reasons;
	}

	/**
	 * Default constructor.
	 */
	public ReportedBlogReasonsOutDto() {
		super();
	}

	/**
	 * Gets the reason of reporting.
	 *
	 * @return reasons.
	 */
	public List<String> getReasons() {
		return reasons;
	}

	/**
	 * Sets the reason of reporting.
	 *
	 * @param reasons
	 */
	public void setReasons(final List<String> reasons) {
		this.reasons = reasons;
	}

	/**
	 * HashCode Generation of {@code ReportedBlogReasonsOutDto}.
	 *
	 * @return Numberic Generation code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(reasons);
	}

	/**
	 * Compare Object.
	 *
	 * @return true if equals or false.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ReportedBlogReasonsOutDto other = (ReportedBlogReasonsOutDto) obj;
		return Objects.equals(reasons, other.reasons);
	}

}
