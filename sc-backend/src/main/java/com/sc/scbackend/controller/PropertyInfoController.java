package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.PropertyInfo;
import com.sc.scbackend.service.PropertyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/house")
public class PropertyInfoController {

    @Autowired
    private PropertyInfoService propertyInfoService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addPropertyInfo(@ModelAttribute PropertyInfo propertyInfo) {

        boolean res = propertyInfoService.save(propertyInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", propertyInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> deletePropertyInfo(@ModelAttribute PropertyInfo propertyInfo) {
        boolean res = propertyInfoService.removeById(propertyInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> updatePropertyInfo(@ModelAttribute PropertyInfo propertyInfo) {

        boolean res = propertyInfoService.updateById(propertyInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", propertyInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}