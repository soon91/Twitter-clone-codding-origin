package com.twitter.clone.twitterclone.global.execption.type;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum TweetErrorCode {

    NO_TWEET(HttpStatus.ACCEPTED, "?");

    private final HttpStatus httpStatus;
    private final String errorMsg;

}
