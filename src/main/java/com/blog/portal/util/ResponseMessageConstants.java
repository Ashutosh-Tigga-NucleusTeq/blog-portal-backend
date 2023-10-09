package com.blog.portal.util;

/**
 * This class contains response messages that are returned by the backend. It's
 * important to ensure that these messages are clear and informative.
 */
public final class ResponseMessageConstants {
	/**
	 * Message: User registration was successful.
	 */
	public static final String USER_REGISTER_SUCCESS = "User registration successful.";

	/**
	 * Message: User registration failed.
	 */
	public static final String USER_REGISTRATION_FAILED = "User registration failed.";

	/**
	 * Message: Blog creation was successful, and it is awaiting ADMIN approval.
	 */
	public static final String BLOG_POST_SUCCESS = "Blog created successfully and awaiting ADMIN approval.";

	/**
	 * Message: Failed to create the blog.
	 */
	public static final String BLOG_POST_FAILED = "Failed to create the blog.";

	/**
	 * Message: Blog update was successful, and it is awaiting ADMIN approval.
	 */
	public static final String BLOG_UPDATE_SUCCESS = "Blog updated successfully and awaiting ADMIN approval.";

	/**
	 * Message: Failed to update the blog.
	 */
	public static final String BLOG_UPDATE_FAILED = "Failed to update the blog.";

	/**
	 * Message: Blog has been reported.
	 */
	public static final String BLOG_REPORT_SUCCESS = "Blog reported.";

	/**
	 * Message: Failed to report the blog.
	 */
	public static final String BLOG_REPORT_FAILED = "Failed to report the blog.";

	/**
	 * Message: Blog has already been reported.
	 */
	public static final String BLOG_ALREADY_REPORTED = "Blog has already been reported.";

	/**
	 * Message: Comment on the blog was successful.
	 */
	public static final String COMMENT_ON_BLOG_SUCCESS = "Comment on blog successful.";

	/**
	 * Message: Failed to add a comment on the blog.
	 */
	public static final String COMMENT_ON_BLOG_FAILED = "Failed to add a comment on the blog.";

	/**
	 * Message: Blog has been approved.
	 */
	public static final String UNREVIEW_BLOG_APPROVED = "Blog approved.";

	/**
	 * Message: Blog has been rejected.
	 */
	public static final String UNREVIEW_BLOG_REJECTED = "Blog rejected.";

	/**
	 * Message: Failed to review the blog.
	 */
	public static final String UNREVIEW_BLOG_FAILED = "Failed to review the blog.";

	/**
	 * Message: Reported blog has been deleted.
	 */
	public static final String REPORTED_BLOG_ACT_DELETED = "Reported blog deleted.";

	/**
	 * Message: Reported blog has been ignored.
	 */
	public static final String REPORTED_BLOG_ACT_IGNORED = "Reported blog ignored.";

	/**
	 * Message: Failed to perform an action on the reported blog.
	 */
	public static final String REPORTED_BLOG_ACT_FAILED = "Failed to perform an action on the reported blog.";
}