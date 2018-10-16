package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
@WebAppConfiguration
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest () {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(1);
        ProductCategory result = repository.save(productCategory);

        Assert.assertNotNull(result);

    }

    @Test
    public void findOneTest () {
        Optional<ProductCategory> productCategory = repository.findById(6);
        if (productCategory.isPresent()) System.out.println(productCategory.get().toString());
    }

    @Test
    public void findByCategoryTypeInTest () {
        List<Integer> list = Arrays.asList(2,3,5,6);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result);
        Assert.assertNotEquals(0, result.size());
//        Optional<ProductCategory> productCategory = repository.findByCategoryTypeIn();
    }


    @Test
    public void updateTest () {
        Optional<ProductCategory> productCategory = repository.findById(7);
        if (productCategory.isPresent()) {
            ProductCategory productCategoryUpdate = productCategory.get();
            productCategoryUpdate.setCategoryName("哈哈最爱");
            productCategoryUpdate.setCategoryType(2);
            ProductCategory result = repository.save(productCategoryUpdate);

            Assert.assertNotNull(result);

            System.out.println(result);
        } else {
            ProductCategory createProductCategory = new ProductCategory();
            createProductCategory.setCategoryName("男生最爱");
            createProductCategory.setCategoryType(2);
            ProductCategory result = repository.save(createProductCategory);
            Assert.assertNotNull(result);
        }

    }
}