

package com.example.webpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.PosService;
import com.example.webpos.controller.api.CategoriesApi;
import com.example.webpos.mapper.CategoryMapper;
import com.example.webpos.model.Category;
import com.example.webpos.model.dto.CategoryDto;



@RestController
@CrossOrigin(originPatterns = "*")
public class CategoriesController implements CategoriesApi{

    private PosService posService;
    private CategoryMapper categoryMapper;

    @Autowired
    public void setPosService(PosService posService,CategoryMapper cate_M) {
        this.posService = posService;
        this.categoryMapper=cate_M;
    }


    @Override
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<Category> categories = posService.categories(); // 调用业务逻辑层获取所有的类别

        if (categories == null || categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有类别，返回无内容状态
        }
        return new ResponseEntity<>(categoryMapper.toCategoryDtoList(categories), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }
}
