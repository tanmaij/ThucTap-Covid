package com.thuctapcovid.thuctapcovid.dto.request.danhSachRaVaoTinh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DanhSachRaVaoTinhDto {
    private Integer maRaVaoTinh;
    private Integer hinhThucVanChuyen;
    private Integer raVaoTinh;
    private String ghiChu;
    private Integer maNguoiDan;
    private String diaChiCanDen;
    private String diaChiHienTai;
    private Integer phongToa;
    private Integer tiemNgua;
    private Integer dongYXetNghiem;
    private String ghiChuXetNghiem;
    private String ghiChuMangThai;
    private Integer nguoiBenhDaKhoi;
    private Integer trangThaiXoa;
}
