package com.blog.portal.enumResource;

/**
 * It represent the status of post. for example suppose if any user do post then
 * his post would go for approval in admin side then his status would be
 * pending. if admin approved that post then post status would be become
 * Approved. or if admin reject that post then post status would be become
 * Rejected.
 */
public enum BlogStatus {
	/**
	 * approved post will be visible to every user.
	 */
	APPROVED,

	/**
	 * pending post will be visible to user itself who posted that post and visible
	 * to admin too.
	 */
	PENDING,

	/**
	 * rejected then it won't be allowed to visible to anyone.
	 */
	REJECTED;
}
