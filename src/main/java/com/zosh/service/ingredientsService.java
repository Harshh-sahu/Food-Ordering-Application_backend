package com.zosh.service;

import com.zosh.model.IngredientCategory;
import com.zosh.model.IngredientsItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ingredientsService {
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngredientCategory findIngredientCategoryById(Long id) throws Exception;

    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;

    public List<IngredientsItem> findRestaurantIngredients(Long restaurantId);

    public IngredientsItem updateStocks(Long id) throws Exception;
}
