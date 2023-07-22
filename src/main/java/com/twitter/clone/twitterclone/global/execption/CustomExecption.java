package com.twitter.clone.twitterclone.global.execption;

import org.springframework.http.HttpStatus;

public interface CustomExecption {

    HttpStatus getHttpStatus();
    String geterrorMsg();

}
