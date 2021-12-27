package com.thuctapcovid.thuctapcovid.dao;

import com.thuctapcovid.thuctapcovid.dto.response.AuthDto;

public interface AuthDao {
    AuthDto login(com.thuctapcovid.thuctapcovid.dto.request.AuthDto authDto);
}
