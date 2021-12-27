package com.thuctapcovid.thuctapcovid.daoimpl;

import com.thuctapcovid.thuctapcovid.dao.NguoiDanDao;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.CapNhatNguoiDanDto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.ThemNguoiDandto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.XoaNguoiDanDto;
import com.thuctapcovid.thuctapcovid.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NguoiDanDaoImpl implements NguoiDanDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void themNguoiDan(ThemNguoiDandto themNguoiDandto) {

        String sql = "{call `covid-19`.sp_NguoiDan_Them(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        int affectRows = jdbcTemplate.update(sql,
                themNguoiDandto.getHoten(),
                themNguoiDandto.getNgaySinh(),
                themNguoiDandto.getDiaChi(),
                themNguoiDandto.getGioiTinh(),
                themNguoiDandto.getCmnd(),
                themNguoiDandto.getSdt(),
                themNguoiDandto.getNgoaiTinh(),
                themNguoiDandto.getDiaChiThuongTru(),
                themNguoiDandto.getHoKinhDoanh(),
                themNguoiDandto.getNganhNghe(),
                themNguoiDandto.getKhuVuc(),
                themNguoiDandto.getMaSoThue(),
                themNguoiDandto.getGpkd(),
                themNguoiDandto.getTrangThaiHoSo(),
                themNguoiDandto.getCongViec(),
                themNguoiDandto.getNoiLamViec(),
                themNguoiDandto.getGhiChu());
        if (affectRows == 0)
            throw new CustomException("Thêm người dân không thành công");
    }

    @Override
    public void capNhatNguoiDan(CapNhatNguoiDanDto capNhatNguoiDan) {
        String sql = "{call `covid-19`.sp_NguoiDan_CapNhat(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        int affectRows = jdbcTemplate.update(sql,
                capNhatNguoiDan.getMaNguoiDan(),
                capNhatNguoiDan.getHoten(),
                capNhatNguoiDan.getNgaySinh(),
                capNhatNguoiDan.getDiaChi(),
                capNhatNguoiDan.getGioiTinh(),
                capNhatNguoiDan.getCmnd(),
                capNhatNguoiDan.getSdt(),
                capNhatNguoiDan.getNgoaiTinh(),
                capNhatNguoiDan.getDiaChiThuongTru(),
                capNhatNguoiDan.getHoKinhDoanh(),
                capNhatNguoiDan.getNganhNghe(),
                capNhatNguoiDan.getKhuVuc(),
                capNhatNguoiDan.getMaSoThue(),
                capNhatNguoiDan.getGpkd(),
                capNhatNguoiDan.getTrangThaiHoSo(),
                capNhatNguoiDan.getCongViec(),
                capNhatNguoiDan.getNoiLamViec(),
                capNhatNguoiDan.getGhiChu());
        if (affectRows == 0)
            throw new CustomException("Cập nhật người dân không thành công");
    }


    @Override
    public void xoaNguoiDan(XoaNguoiDanDto xoaNguoiDan) {
        String sql = "{call `covid-19`.sp_NguoiDan_XoaKhoiPhuc(?,?)}";
        int affectRows = jdbcTemplate.update(sql, xoaNguoiDan.getMaNguoiDan(), xoaNguoiDan.getTrangThaiXoa());
        if (affectRows == 0)
            throw new CustomException("Xóa người dân không thành công");

    }

    @Override
    public List<Map<String, Object>> layNguoiDan() {
        String sql = "{call `covid-19`.sp_NguoiDan_Get()}";
        return jdbcTemplate.queryForList(sql);
    }
}
