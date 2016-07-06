package com.readytalk.simpleApp.schedule;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No Games! All clear")
public class NoGameException extends RuntimeException {
}
