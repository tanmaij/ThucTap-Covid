package com.thuctapcovid.thuctapcovid.resource;

import com.thuctapcovid.thuctapcovid.common.NguoiDanConstants;
import com.thuctapcovid.thuctapcovid.dao.NguoiDanDao;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.CapNhatNguoiDanDto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.ThemNguoiDandto;
import com.thuctapcovid.thuctapcovid.dto.request.nguoiDan.XoaNguoiDanDto;
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

@RequestMapping("/api" + NguoiDanConstants.ROOT)
@RestController
public class NguoiDanResource {
    @Autowired
    private NguoiDanDao nguoiDanDao;

    @PostMapping(NguoiDanConstants.THEM_NGUOI_DAN)
    public ResponseEntity<NonQueryDto> add(@RequestBody ThemNguoiDandto themNguoiDandto) {
        nguoiDanDao.themNguoiDan(themNguoiDandto);
        return ResponseEntity.ok().body(new NonQueryDto("Thêm thành công"));
    }

    @PutMapping(NguoiDanConstants.CAP_NHAT_NGUOI_DAN)
    public ResponseEntity<NonQueryDto> update(@RequestBody CapNhatNguoiDanDto capNhatNguoiDanDto) {
        nguoiDanDao.capNhatNguoiDan(capNhatNguoiDanDto);
        return ResponseEntity.ok().body(new NonQueryDto("Cập nhật thành công"));
    }

    @DeleteMapping(NguoiDanConstants.XOA_NGUOI_DAN)
    public ResponseEntity<NonQueryDto> delete(@RequestBody XoaNguoiDanDto xoaNguoiDanDto) {
        nguoiDanDao.xoaNguoiDan(xoaNguoiDanDto);
        return ResponseEntity.ok().body(new NonQueryDto("Xóa thành công"));
    }

    @GetMapping(NguoiDanConstants.LAY_NGUOI_DAN)
    public ResponseEntity<List<Map<String, Object>>> get() {
        return ResponseEntity.ok(nguoiDanDao.layNguoiDan());
    }

    @GetMapping(NguoiDanConstants.XUAT_NGUOI_DAN)
    public ResponseEntity<ByteArrayResource> exports() {
        String path="templates/danh_sach_nguoi_dan.jrxml";
        byte[] file = JasperUtils.getReport(nguoiDanDao.layNguoiDan(),path);
        return ResponseEntity
                .ok()
                .headers(headers -> {
                    ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                            .filename("nguoi_dan.pdf")
                            .build();
                    headers.setContentLength(file.length);
                    headers.setContentDisposition(contentDisposition);
                    headers.setContentType(MediaType.APPLICATION_PDF);
                })
                .body(new ByteArrayResource(file));
    }
}
