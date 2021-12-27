package com.thuctapcovid.thuctapcovid.resource;

import com.thuctapcovid.thuctapcovid.common.DangKyVeQueConstants;
import com.thuctapcovid.thuctapcovid.dao.DangKyVeQueDao;
import com.thuctapcovid.thuctapcovid.dto.request.dangKyVeQue.DangKyVeQueDto;
import com.thuctapcovid.thuctapcovid.dto.response.NonQueryDto;
import com.thuctapcovid.thuctapcovid.utils.JasperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api"+DangKyVeQueConstants.ROOT)
public class DangKyVeQueResource {
    @Autowired
    DangKyVeQueDao dangKyVeQueDao;
    @GetMapping(DangKyVeQueConstants.LAY_DANH_SACH_DANG_KY_VE_QUE)
    public ResponseEntity<List<Map<String,Object>>> get()
    {

        return ResponseEntity.ok().body(dangKyVeQueDao.layDanhSachDangKyVeQue());
    }
    @PostMapping(DangKyVeQueConstants.THEM_DANG_KY_VE_QUE)
    public ResponseEntity<NonQueryDto> add(@RequestBody DangKyVeQueDto dangKyVeQueDto)
    {
        dangKyVeQueDao.themDangKyVeQue(dangKyVeQueDto);
        return ResponseEntity.ok().body(new NonQueryDto("Thêm thành công"));
    }
    @PutMapping(DangKyVeQueConstants.CAP_NHAT_DANG_KY_VE_QUE)
    public ResponseEntity<NonQueryDto> update(@RequestBody DangKyVeQueDto dangKyVeQueDto)
    {
        dangKyVeQueDao.capNhatDangKyVeQue(dangKyVeQueDto);
        return ResponseEntity.ok().body(new NonQueryDto("Cập nhật thành công"));
    }
    @DeleteMapping(DangKyVeQueConstants.XOA_DANG_KY_VE_QUE)
    public ResponseEntity<NonQueryDto> delete(@RequestBody DangKyVeQueDto dangKyVeQueDto)
    {
        dangKyVeQueDao.xoaDangKyVeQue(dangKyVeQueDto);
        return ResponseEntity.ok().body(new NonQueryDto("Xóa thành công"));
    }
    @GetMapping(DangKyVeQueConstants.XUAT_DANH_SACH_DANG_KY_VE_QUE)
    public ResponseEntity<ByteArrayResource> export()
    {
        String path="templates/danh_sach_dang_ky_ve_que.jrxml";
        byte[] file = JasperUtils.getReport(dangKyVeQueDao.layDanhSachDangKyVeQue(),path);
        return ResponseEntity
                .ok()
                .headers(headers -> {
                    ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                            .filename("danh_sach_ve_que.pdf")
                            .build();
                    headers.setContentLength(file.length);
                    headers.setContentDisposition(contentDisposition);
                    headers.setContentType(MediaType.APPLICATION_PDF);
                })
                .body(new ByteArrayResource(file));
    }

}
