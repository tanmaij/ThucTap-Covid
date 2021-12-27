package com.thuctapcovid.thuctapcovid.daoimpl;

import com.thuctapcovid.thuctapcovid.dao.AuthDao;
import com.thuctapcovid.thuctapcovid.dto.response.AuthDto;
import com.thuctapcovid.thuctapcovid.exception.AuthorizationException;
import com.thuctapcovid.thuctapcovid.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AuthDaoImpl implements AuthDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JwtUtils jwtUtils;
    @Override
    public AuthDto login(com.thuctapcovid.thuctapcovid.dto.request.AuthDto authDto) {
        String sql="{call `covid-19`.sp_TaiKhoan_Check(?,?)}";
        List<Map<String,Object>> results=jdbcTemplate.queryForList(sql,authDto.getMa_tai_khoan(),authDto.getMat_khau());
        if(results.size()<1)
            throw  new AuthorizationException("Sai thông tin đăng nhập");
        System.out.println(results);
        return new AuthDto(jwtUtils.generateAccessToken(authDto.getMa_tai_khoan()),authDto.getMa_tai_khoan());
    }
}
