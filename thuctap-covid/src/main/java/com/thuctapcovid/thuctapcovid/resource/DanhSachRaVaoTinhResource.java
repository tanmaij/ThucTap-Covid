package com.thuctapcovid.thuctapcovid.resource;

import com.thuctapcovid.thuctapcovid.common.DanhSachRaVaoTinhConstants;
import com.thuctapcovid.thuctapcovid.dao.DanhSachRaVaoTinhDao;
import com.thuctapcovid.thuctapcovid.dto.request.danhSachRaVaoTinh.DanhSachRaVaoTinhDto;
import com.thuctapcovid.thuctapcovid.dto.response.NonQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api"+ DanhSachRaVaoTinhConstants.ROOT)
public class DanhSachRaVaoTinhResource {
    @Autowired
    DanhSachRaVaoTinhDao danhSachRaVaoTinhDao;

    @PostMapping(DanhSachRaVaoTinhConstants.THEM_DANH_SACH_RA_VAO_TINH)
    public ResponseEntity<NonQueryDto> add(@RequestBody DanhSachRaVaoTinhDto danhSachRaVaoTinhDto){
        danhSachRaVaoTinhDao.themRaVaoTinh(danhSachRaVaoTinhDto);
        return ResponseEntity.ok(new NonQueryDto("Thêm thành công"));
    }
    @PutMapping(DanhSachRaVaoTinhConstants.CAP_NHAT_DANH_SACH_RA_VAO_TINH)
    public ResponseEntity<NonQueryDto> update(@RequestBody DanhSachRaVaoTinhDto danhSachRaVaoTinhDto){
        danhSachRaVaoTinhDao.capNhatRaVaoTinh(danhSachRaVaoTinhDto);
        return ResponseEntity.ok(new NonQueryDto("Cập nhật thành công"));
    }
    @DeleteMapping(DanhSachRaVaoTinhConstants.XOA_DANH_SACH_RA_VAO_TINH)
    public ResponseEntity<NonQueryDto> delete(@RequestBody DanhSachRaVaoTinhDto danhSachRaVaoTinhDto){
        danhSachRaVaoTinhDao.xoaRaVaoTinh(danhSachRaVaoTinhDto);
        return ResponseEntity.ok(new NonQueryDto("Xóa thành công"));
    }
    @GetMapping(DanhSachRaVaoTinhConstants.LAY_DANH_SACH_RA_VAO_TINH)
    public ResponseEntity<List<Map<String,Object>>> get(){
         return ResponseEntity.ok().body(danhSachRaVaoTinhDao.layDanhSachRaVaoTinh());

    }

}
