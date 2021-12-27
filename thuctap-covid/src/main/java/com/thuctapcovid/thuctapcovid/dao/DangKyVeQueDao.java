package com.thuctapcovid.thuctapcovid.dao;

import com.thuctapcovid.thuctapcovid.dto.request.dangKyVeQue.DangKyVeQueDto;

import java.util.List;
import java.util.Map;

public interface DangKyVeQueDao {
    void themDangKyVeQue(DangKyVeQueDto dangKyVeQueDto);
    void capNhatDangKyVeQue(DangKyVeQueDto dangKyVeQueDto);
    void xoaDangKyVeQue(DangKyVeQueDto dangKyVeQueDto);
    List<Map<String,Object>> layDanhSachDangKyVeQue();

}
