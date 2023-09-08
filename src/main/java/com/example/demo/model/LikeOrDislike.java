package com.example.demo.model;

import com.example.demo.enumResource.React;

/**
 * This entity stores the information of user reaction.
 */
public class LikeOrDislike {

	/**
	 * Id of the LikeOrDislike.
	 */
	private String id;

	/**
	 * Id of the Post.
	 */
	private Post postId;

	/**
	 * Id of the User.
	 */
	private User userId;

	/**
	 * Type of the React like or dislike.
	 */
	private React type;
}
