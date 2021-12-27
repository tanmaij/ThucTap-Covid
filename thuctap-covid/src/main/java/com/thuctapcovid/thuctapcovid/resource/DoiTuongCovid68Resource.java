package com.thuctapcovid.thuctapcovid.resource;

import com.thuctapcovid.thuctapcovid.common.DoiTuongCovidNQ68Constant;
import com.thuctapcovid.thuctapcovid.dao.DoiTuongCovidNQ68Dao;
import com.thuctapcovid.thuctapcovid.dto.request.doiTuongCovidNQ68.DoiTuongCovidNQ68Dto;
import com.thuctapcovid.thuctapcovid.dto.response.NonQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api"+ DoiTuongCovidNQ68Constant.ROOT)
public class DoiTuongCovid68Resource {
    @Autowired
    DoiTuongCovidNQ68Dao doiTuongCovidNQ68Dao;
    @PostMapping(DoiTuongCovidNQ68Constant.THEM_DOI_TUONG_COVID_NQ68)
    public ResponseEntity<NonQueryDto> add(@RequestBody DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto)
    {
        doiTuongCovidNQ68Dao.themDoiTuongCovidNQ68(doiTuongCovidNQ68Dto);
        return ResponseEntity.ok().body(new NonQueryDto("Thêm thành công"));
    }
    @PutMapping(DoiTuongCovidNQ68Constant.CAP_NHAT_DOI_TUONG_COVID_NQ68)
    public ResponseEntity<NonQueryDto> update(@RequestBody DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto)
    {
        doiTuongCovidNQ68Dao.capNhatDoiTuongCovidNQ68(doiTuongCovidNQ68Dto);
        return ResponseEntity.ok().body(new NonQueryDto("Cập nhật thành công"));
    }
    @DeleteMapping(DoiTuongCovidNQ68Constant.XOA_DOI_TUONG_COVID_NQ68)
    public ResponseEntity<NonQueryDto> delete(@RequestBody DoiTuongCovidNQ68Dto doiTuongCovidNQ68Dto)
    {
        doiTuongCovidNQ68Dao.xoaDoiTuongCovidNQ68(doiTuongCovidNQ68Dto);
        return ResponseEntity.ok().body(new NonQueryDto("Xóa thành công"));
    }
    @GetMapping(DoiTuongCovidNQ68Constant.LAY_DANH_SACH_DOI_TUONG_COVID_NQ68)
    public ResponseEntity<List<Map<String,Object>>> get()
    {
        return ResponseEntity.ok().body(doiTuongCovidNQ68Dao.layDanhSachDoiTuongCovidNQ68());
    }
}
