package com.thuctapcovid.thuctapcovid.dao;

import com.thuctapcovid.thuctapcovid.dto.request.danhSachRaVaoTinh.DanhSachRaVaoTinhDto;

import java.util.List;
import java.util.Map;

public interface DanhSachRaVaoTinhDao {
    void themRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto);
    void capNhatRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto);
    void xoaRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto);
    List<Map<String,Object>> layDanhSachRaVaoTinh();
}
