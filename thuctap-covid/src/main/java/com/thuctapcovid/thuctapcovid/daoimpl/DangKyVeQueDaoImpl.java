package com.thuctapcovid.thuctapcovid.daoimpl;

import com.thuctapcovid.thuctapcovid.dao.DangKyVeQueDao;
import com.thuctapcovid.thuctapcovid.dto.request.dangKyVeQue.DangKyVeQueDto;
import com.thuctapcovid.thuctapcovid.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DangKyVeQueDaoImpl implements DangKyVeQueDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void themDangKyVeQue(DangKyVeQueDto dangKyVeQueDto) {
        String sql = "{call `covid-19`.sp_DangKyVeQue_Them(?,?,?,?,?,?,?,?,?,?,?)}";
        int affectRows = jdbcTemplate.update(sql,
                dangKyVeQueDto.getMaNguoiDan(),
                dangKyVeQueDto.getHinhThucVanChuyen(),
                dangKyVeQueDto.getGhiChu(),
                dangKyVeQueDto.getDiaChiHienTai(),
                dangKyVeQueDto.getDiaChiTroVe(),
                dangKyVeQueDto.getPhongToa(),
                dangKyVeQueDto.getTiemNgua(),
                dangKyVeQueDto.getDongYXetNghiem(),
                dangKyVeQueDto.getGhiChuXetNghiem(),
                dangKyVeQueDto.getGhiChuMangThai(),
                dangKyVeQueDto.getNguoiBenhDaKhoi());
    if(affectRows==0)
        throw  new CustomException("Thêm không thành công");
    }

    @Override
    public void capNhatDangKyVeQue(DangKyVeQueDto dangKyVeQueDto) {
        System.out.println(dangKyVeQueDto.getGhiChuMangThai());
        String sql = "{call `covid-19`.sp_DangKyVeQue_CapNhat(?,?,?,?,?,?,?,?,?,?,?)}";
        int affectRows = jdbcTemplate.update(sql,
                dangKyVeQueDto.getMaDangKyVeQue(),
                dangKyVeQueDto.getHinhThucVanChuyen(),
                dangKyVeQueDto.getGhiChu(),
                dangKyVeQueDto.getDiaChiHienTai(),
                dangKyVeQueDto.getDiaChiTroVe(),
                dangKyVeQueDto.getPhongToa(),
                dangKyVeQueDto.getTiemNgua(),
                dangKyVeQueDto.getDongYXetNghiem(),
                dangKyVeQueDto.getGhiChuXetNghiem(),
                dangKyVeQueDto.getGhiChuMangThai(),
                dangKyVeQueDto.getNguoiBenhDaKhoi());
        if(affectRows==0)
            throw  new CustomException("Cập nhật không thành công");
    }

    @Override
    public void xoaDangKyVeQue(DangKyVeQueDto dangKyVeQueDto) {
        String sql="{call `covid-19`.sp_DangKyVeQue_Xoa(?)}";
        int affectRows=jdbcTemplate.update(sql,dangKyVeQueDto.getMaDangKyVeQue());
        if(affectRows==0)
            throw new CustomException("Xóa không thành công");
    }

    @Override
    public List<Map<String, Object>> layDanhSachDangKyVeQue() {
        String sql="{call `covid-19`.sp_LayDanhSachVeQue()}";
        return jdbcTemplate.queryForList(sql);
    }
}
