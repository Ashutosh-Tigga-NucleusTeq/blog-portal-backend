package com.blog.portal.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.requestPayload.ReportedPostInDto;
import com.blog.portal.requestPayload.ActionOnReportedPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.ReportedPostOutDto;
import com.blog.portal.services.ReportedPostService;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/blog/portal")
public class ReportedPostController {

	/**
	 * Instance of reportedPostRepo.
	 */
    @Autowired
    private ReportedPostService reportedPostService;

    /**
     * An instance of the Logger class for logging.
     */
    private Logger logger = LogManager.getLogger(ReportedPostController.class);

    /**
     * This Api for reporting post.
     * @param inDto
     * @return response
     */
    @PostMapping("report/post")
    public ApiResponse reportedPost(@Valid @RequestBody ReportedPostInDto inDto) {
    	logger.info(" Reporting post controller invoked with request inDto [" + inDto + "]");
    	ApiResponse response = reportedPostService.reportPost(inDto);
    	logger.info("Fetching response from reportPost method of Service [" + response + "]");
    	return response;
    }

    /**
     * Gets all Reporeted post.
     * @return response
     */
    @GetMapping("getAll/reportedPost")
    public List<ReportedPostOutDto> getAllReportedPosts() {
    	List<ReportedPostOutDto> response = reportedPostService.getAllReportedPost();
    	return response;
    }
    /**
     * Response on reported Blog post.
     * @param inDto contains reportedpost id and action of admin.
     * @return response proper Response message with success value true or false.
     */
    @PostMapping("actOnReportedBlog")
    private ApiResponse actOnReportedBlog(@Valid @RequestBody ActionOnReportedPostInDto inDto) {
    	logger.info("Response on reported blog post controller with request payload [" + inDto + "]");
    	ApiResponse response = reportedPostService.actOnReportedBlog(inDto);
    	logger.info("Fetching response from responseReportedblog [" + response + "]");
    	return response;
    }
}
