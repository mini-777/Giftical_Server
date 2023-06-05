package com.Giftical.Giftical.BusinessUser;


import com.Giftical.Giftical.Store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequiredArgsConstructor
public class BusinessUserController {
    private final BusinessUserService businessUserService;

    @PostMapping("/vendor/login")
    public ResponseEntity<List<Store>> login(@RequestBody Map<String, String> requestData){

        return businessUserService.login(requestData.get("businessId"),requestData.get("businessPw"));
    }

    @PostMapping("/vendor/join")
    public ResponseEntity<List<Store>> join(@RequestBody BusinessJoinDTO businessJoinDTO){

        BusinessUser newUser = businessUserService.join(businessJoinDTO);
        return businessUserService.login(newUser.getBusinessUserId(), newUser.getBusinessUserPw());
    }
    
}
