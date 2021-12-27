package com.thuctapcovid.thuctapcovid.dao;

import com.thuctapcovid.thuctapcovid.dto.request.doiTuongCovidNQ68.DoiTuongCovidNQ68Dto;

import java.util.List;
import java.util.Map;

public interface DoiTuongCovidNQ68Dao {
    void themDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto);
    void capNhatDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto);
    void xoaDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto);
    List<Map<String,Object>> layDanhSachDoiTuongCovidNQ68();
}
