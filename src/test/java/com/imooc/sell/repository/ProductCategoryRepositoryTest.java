package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void saveTest () {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
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
    @Transactional
    public void updateTest () {
        Optional<ProductCategory> productCategory = repository.findById(7);
        if (productCategory.isPresent()) {
            ProductCategory productCategoryUpdate = productCategory.get();
            productCategoryUpdate.setCategoryName("哈哈最爱");
            productCategoryUpdate.setCategoryType(15);
            ProductCategory result = repository.save(productCategoryUpdate);

            Assert.assertNotNull(result);

            System.out.println(result);
        } else {
            ProductCategory createProductCategory = new ProductCategory();
            createProductCategory.setCategoryName("人妖最爱");
            createProductCategory.setCategoryType(12);
            ProductCategory result = repository.save(createProductCategory);
            Assert.assertNotNull(result);
        }

    }
}