package com.blog.portal.responsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReportedPostMessageOutDto {
	/**
	 * Reason of reporting on particular post.
	 */
	private List<String> reasons = new ArrayList<String>();

	/**
	 * String representation of {@code ReportedPostMessageOutDto}.
	 */
	@Override
	public String toString() {
		return "ReportedPostMessageOutDto [reasons=" + reasons + "]";
	}

	/**
	 * Parameterized constructor.
	 * @param reasons
	 */
	public ReportedPostMessageOutDto(List<String> reasons) {
		super();
		this.reasons = reasons;
	}

	/**
	 * Default constructor.
	 */
	public ReportedPostMessageOutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the reason of reporting.
	 * @return reasons.
	 */
	public List<String> getReasons() {
		return reasons;
	}

	/**
	 * Sets the reason of reporting.
	 * @param reasons
	 */
	public void setReasons(List<String> reasons) {
		this.reasons = reasons;
	}

	/**
	 * HashCode Generation of {@code ReportedPostMessageOutDto}.
	 * @return Numberic Generation code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(reasons);
	}

	/**
	 * Compare Object.
	 * @return true if equals or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ReportedPostMessageOutDto other = (ReportedPostMessageOutDto) obj;
		return Objects.equals(reasons, other.reasons);
	}

}
