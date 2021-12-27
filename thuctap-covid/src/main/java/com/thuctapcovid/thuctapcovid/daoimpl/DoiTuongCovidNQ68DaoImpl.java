package com.thuctapcovid.thuctapcovid.daoimpl;

import com.thuctapcovid.thuctapcovid.dao.DoiTuongCovidNQ68Dao;
import com.thuctapcovid.thuctapcovid.dto.request.doiTuongCovidNQ68.DoiTuongCovidNQ68Dto;
import com.thuctapcovid.thuctapcovid.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DoiTuongCovidNQ68DaoImpl implements DoiTuongCovidNQ68Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void themDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto) {
        String sql = "call `covid-19`.sp_DoiTuongCovidNQ68_them(?,?,?)";
        int affectRows=jdbcTemplate.update(sql, doiTuongCovidNQ68Dto.getMaNguoiDan(), doiTuongCovidNQ68Dto.getThoiDiemMatViec(), doiTuongCovidNQ68Dto.getNganhNgheMongMuon());
        if(affectRows==0)
            throw new CustomException("Thêm không thành công");
    }

    @Override
    public void capNhatDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto) {
        String sql = "call `covid-19`.sp_DoiTuongCovidNQ68_CapNhat(?,?,?,?)";
        int affectRows=jdbcTemplate.update(sql, doiTuongCovidNQ68Dto.getMaNguoiDan(), doiTuongCovidNQ68Dto.getThoiDiemMatViec(), doiTuongCovidNQ68Dto.getNganhNgheMongMuon(),doiTuongCovidNQ68Dto.getTrangThaiHoSo());
        if(affectRows==0)
            throw new CustomException("Cập nhật không thành công");
    }

    @Override
    public void xoaDoiTuongCovidNQ68(DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto) {
        String sql = "call `covid-19`.sp_DoiTuongCovidNQ68_Xoa(?)";
        System.out.println(doiTuongCovidNQ68Dto.getMaNguoiDan());
        int affectRows=jdbcTemplate.update(sql, doiTuongCovidNQ68Dto.getMaNguoiDan());
        if(affectRows==0)
            throw new CustomException("Xóa không thành công");
    }

    @Override
    public List<Map<String, Object>> layDanhSachDoiTuongCovidNQ68() {
        String sql = "call `covid-19`.sp_LayDanhSachDoiTuongCovid()";
        return jdbcTemplate.queryForList(sql);
    }
}
