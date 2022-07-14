package com.example.lakers.service.impl;

import com.example.lakers.model.entity.CategoryEntity;
import com.example.lakers.model.entity.enums.CategoryNameEnum;
import com.example.lakers.repository.CategoryRepository;
import com.example.lakers.service.CategoryService;
import org.springframework.stereotype.Service;


import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values()).forEach(categoryNameEnum -> {
                CategoryEntity category = new CategoryEntity(categoryNameEnum, "Description for " + categoryNameEnum.name());

                categoryRepository.save(category);
            });
        }
    }
}