package com.example.demo.model;

import com.example.demo.enumResource.ReportAction;

/**
 * This Entity is for handling the repoeted Post.
 */
public class ReportedPost {

	/**
	 * id of the ReportedPost document.
	 */
	private String id;

	/**
	 * Id of the post.
	 */
	private Post postId;

	/**
	 * Id of the User.
	 */
	private User userId;

	/**
	 * Message that contains reason of repoting post.
	 */
	private String reportReason;

	/**
	 * action od admin on Repoted Post.
	 */
	private ReportAction adminAction;
}
