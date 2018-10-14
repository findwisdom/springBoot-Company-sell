package com.imooc.sell.service.Impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.event.ListDataEvent;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(6);
        Assert.assertEquals(new Integer(6), productCategory.getId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2,6,7);
        List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategoryList.size());

    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("大家最爱");
        productCategory.setCategoryType(1);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}