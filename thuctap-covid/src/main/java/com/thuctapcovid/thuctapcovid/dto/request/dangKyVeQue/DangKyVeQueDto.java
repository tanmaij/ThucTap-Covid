package com.thuctapcovid.thuctapcovid.dto.request.dangKyVeQue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DangKyVeQueDto {
    private Integer maDangKyVeQue;
    private Integer maNguoiDan;
    private Integer hinhThucVanChuyen;
    private String ghiChu;
    private String diaChiHienTai;
    private String diaChiTroVe;
    private String phongToa;
    private String tiemNgua;
    private Integer dongYXetNghiem;
    private String ghiChuXetNghiem;
    private String ghiChuMangThai;
    private Integer nguoiBenhDaKhoi;
    private Integer trangThaiXoa;
}
