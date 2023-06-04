package com.Giftical.Giftical.BusinessUser;


import com.Giftical.Giftical.Store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@RestController
@RequiredArgsConstructor
public class BusinessUserController {
    private final BusinessUserService businessUserService;

    @PostMapping("/vendor/login")
    public ResponseEntity<List<Store>> login(@RequestBody Map<String, String> requestData){
        log.println(requestData.get("businessId"));
        log.println(requestData.get("businessPw"));
        return businessUserService.login(requestData.get("businessId"),requestData.get("businessPw"));
    }
}