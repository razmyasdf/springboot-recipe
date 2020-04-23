package com.sixonix.recipe.repositories;

import com.sixonix.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
