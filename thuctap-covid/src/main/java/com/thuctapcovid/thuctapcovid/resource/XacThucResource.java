package com.thuctapcovid.thuctapcovid.resource;

import com.thuctapcovid.thuctapcovid.common.AuthConstants;
import com.thuctapcovid.thuctapcovid.dao.AuthDao;
import com.thuctapcovid.thuctapcovid.dto.request.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api" + AuthConstants.ROOT)
public class XacThucResource {
    @Autowired
    AuthDao authDao;
    @PostMapping(AuthConstants.LOGIN)
    public ResponseEntity<com.thuctapcovid.thuctapcovid.dto.response.AuthDto> login(@RequestBody AuthDto authDto) {
        System.out.println(authDto);
        return ResponseEntity.ok(authDao.login(authDto));
    }

}
