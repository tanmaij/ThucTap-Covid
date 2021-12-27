package com.thuctapcovid.thuctapcovid.daoimpl;

import com.thuctapcovid.thuctapcovid.dao.DanhSachRaVaoTinhDao;
import com.thuctapcovid.thuctapcovid.dto.request.danhSachRaVaoTinh.DanhSachRaVaoTinhDto;
import com.thuctapcovid.thuctapcovid.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DanhSachRaVaoTinhDaoImpl implements DanhSachRaVaoTinhDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void themRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto) {
        String sql = "{call `covid-19`.sp_DanhSachRaVaoTinh_Them(?,?,?,?,?,?,?,?,?,?)}";

        int affectRows = jdbcTemplate.update(sql,
                danhSachRaVaoTinhDto.getMaNguoiDan(),
                danhSachRaVaoTinhDto.getRaVaoTinh(),
                danhSachRaVaoTinhDto.getDiaChiHienTai(),
                danhSachRaVaoTinhDto.getDiaChiCanDen(),
                danhSachRaVaoTinhDto.getPhongToa(),
                danhSachRaVaoTinhDto.getTiemNgua(),
                danhSachRaVaoTinhDto.getDongYXetNghiem(),
                danhSachRaVaoTinhDto.getGhiChuXetNghiem(),
                danhSachRaVaoTinhDto.getGhiChuMangThai(),
                danhSachRaVaoTinhDto.getNguoiBenhDaKhoi()
                );
        if(affectRows==0)
            throw  new CustomException("Thêm không thành công");
    }

    @Override
    public void capNhatRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto) {
        String sql = "{call `covid-19`.sp_DanhSachRaVaoTinh_CapNhat(?,?,?,?,?,?,?,?,?,?)}";
        int affectRows = jdbcTemplate.update(sql,
                danhSachRaVaoTinhDto.getMaRaVaoTinh(),
                danhSachRaVaoTinhDto.getRaVaoTinh(),
                danhSachRaVaoTinhDto.getDiaChiCanDen(),
                danhSachRaVaoTinhDto.getDiaChiHienTai(),
                danhSachRaVaoTinhDto.getPhongToa(),
                danhSachRaVaoTinhDto.getTiemNgua(),
                danhSachRaVaoTinhDto.getDongYXetNghiem(),
                danhSachRaVaoTinhDto.getGhiChuXetNghiem(),
                danhSachRaVaoTinhDto.getGhiChuMangThai(),
                danhSachRaVaoTinhDto.getNguoiBenhDaKhoi()
        );
        if(affectRows==0)
            throw  new CustomException("Cập nhật không thành công");
    }

    @Override
    public void xoaRaVaoTinh(DanhSachRaVaoTinhDto danhSachRaVaoTinhDto) {
        String sql = "{call `covid-19`.sp_DanhSachRaVaoTinh_Xoa(?)}";
        int affectRows = jdbcTemplate.update(sql,
                danhSachRaVaoTinhDto.getMaRaVaoTinh()
        );
        if(affectRows==0)
            throw  new CustomException("Xóa không thành công");
    }

    @Override
    public List<Map<String, Object>> layDanhSachRaVaoTinh() {
        String sql="{call `covid-19`.sp_DanhSachRaVaoTinh_Get()}";
        return jdbcTemplate.queryForList(sql);
    }

}
