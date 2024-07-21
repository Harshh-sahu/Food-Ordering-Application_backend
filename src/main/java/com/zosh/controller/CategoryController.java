package com.zosh.controller;


import com.zosh.model.Category;
import com.zosh.model.Restaurant;
import com.zosh.model.User;
import com.zosh.repository.CategoryRepository;
import com.zosh.service.CategoryService;
import com.zosh.service.RestaurantService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Category createCategory = categoryService.createCategory(category.getName(), user.getId());

        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }


    @GetMapping("/category/restaurant/{id}")
    public ResponseEntity<List<Category>> getRestaurantCategory(@PathVariable Long id,
                                                                @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

//        Restaurant restaurant = restaurantService.findRestaurantById(id);
//        Long Id = restaurant.getId();
        Long Id = restaurantService.findOwnerByRestaurantId(id);

        System.out.println(Id);
        List<Category> categories = categoryService.findCategoryByRestaurantId(Id);
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }
}
