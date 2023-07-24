package com.twitter.clone.twitterclone.tweet.controller;

import com.twitter.clone.twitterclone.global.model.response.CustomResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {

    @PostMapping
    public CustomResponse<String> ar(){
        return CustomResponse.success("test", "test");
    }

}
