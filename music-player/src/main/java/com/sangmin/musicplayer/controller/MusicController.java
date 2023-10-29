package com.sangmin.musicplayer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {

    @GetMapping("/")
    public String Test() {
        return "Test";
    }
}
