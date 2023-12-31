package com.blog.portal.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.requestPayload.ReportBlogInDto;
import com.blog.portal.requestPayload.ActOnReportedBlogInDto;
import com.blog.portal.responsePayload.ReportedBlogReasonsOutDto;
import com.blog.portal.responsePayload.ReportedBlogsOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.ReportService;
import com.blog.portal.util.RestPathConstants;

import java.util.List;

import javax.validation.Valid;

/**
 * This class handles HTTP requests related to REPORT BLOGS.
 * It provides API end-points for creating and managing REPORTING BLOGS.
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping(RestPathConstants.REPORT_URL)
public class ReportController {

	/**
	 * Instance of reportedPostRepo.
	 */
	@Autowired
	private ReportService reportService;

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ReportController.class);

	/**
	 * This API end-point for reporting post.
	 * @param inDto
	 * @return response
	 */
	@PostMapping("/")
	public ResponseEntity<ResponseOutDTO> doReport(@Valid @RequestBody final ReportBlogInDto inDto) {
		LOGGER.info(" Reporting post controller invoked with request inDto [" + inDto + "]");
		ResponseOutDTO response = reportService.reportOnBlog(inDto);
		LOGGER.info("Fetching response from reportPost method of Service [" + response + "]");
		return new ResponseEntity<ResponseOutDTO>(response, HttpStatus.CREATED);
	}

	/**
	 * Gets all Reported post.
	 * @return response
	 */
	@GetMapping("/all/reported/blogs")
	public List<ReportedBlogsOutDto> getReportedBlogs() {
		LOGGER.info(" Get all reported blog controller invoked ");
		List<ReportedBlogsOutDto> response = reportService.getReportedBlogs();
		LOGGER.info("Fetching response from getAllReportedPost method of Service [" + response + "]");
		return response;
	}

	/**
	 * API end-point to perform action on reported BLOG.
	 * it could be either Delete or Ignore.
	 * @param inDto contains REPORTEDPOST id and action of ADMIN.
	 * @return response proper Response message with success value true or false.
	 */
	@PostMapping("/blog/action")
	public ResponseOutDTO actOnReportedBlog(@Valid @RequestBody final ActOnReportedBlogInDto inDto) {
		LOGGER.info("Response on reported blog post controller with request payload [" + inDto + "]");
		ResponseOutDTO response = reportService.actOnReportedBlog(inDto);
		LOGGER.info("Fetching response from responseReportedblog [" + response + "]");
		return response;
	}

	/**
	 * API for fetching report reason of BLOG by it's ID.
	 * @param postId
	 * @return response Reason of reporting.
	 */
	@GetMapping("/{postId}")
	public ReportedBlogReasonsOutDto getReportReasons(@PathVariable final String postId) {
		LOGGER.info("Get Reported Blog Rason message contoller invoked with postId [" + postId + "]");
		ReportedBlogReasonsOutDto response = reportService.getReportedBlogReason(postId);
		LOGGER.info("Fetching response from getMessage [" + response + "]");
		return response;
	}
}
