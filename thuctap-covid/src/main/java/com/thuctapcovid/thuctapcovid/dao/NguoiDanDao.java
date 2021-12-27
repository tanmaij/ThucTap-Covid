package com.thuctapcovid.thuctapcovid.dao;


import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.CapNhatNguoiDanDto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.ThemNguoiDandto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.XoaNguoiDanDto;

import java.util.List;
import java.util.Map;

public interface NguoiDanDao {
    void themNguoiDan(ThemNguoiDandto themNguoiDandto);
    void capNhatNguoiDan(CapNhatNguoiDanDto capNhatNguoiDan);
    void xoaNguoiDan(XoaNguoiDanDto xoaNguoiDan);
    List<Map<String,Object>> layNguoiDan();
}
