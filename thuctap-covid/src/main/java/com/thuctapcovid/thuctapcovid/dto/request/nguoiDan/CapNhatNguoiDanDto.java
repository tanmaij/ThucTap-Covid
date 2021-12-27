package com.thuctapcovid.thuctapcovid.dto.request.nguoiDan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapNhatNguoiDanDto {
    private int MaNguoiDan;
    private String hoten;
    private String ngaySinh;
    private String diaChi;
    private Integer gioiTinh;
    private String cmnd;
    private String sdt;
    private Integer ngoaiTinh;
    private String diaChiThuongTru;
    private String hoKinhDoanh;
    private Integer nganhNghe;
    private String khuVuc;
    private Integer trangThaiHoSo;
    private String maSoThue;
    private String gpkd;
    private String congViec;
    private String ghiChu;
    private String noiLamViec;
}
