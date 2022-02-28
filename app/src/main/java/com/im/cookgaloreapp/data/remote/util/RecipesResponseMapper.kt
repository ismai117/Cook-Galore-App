package com.im.cookgaloreapp.data.remote.util

import com.im.cookgaloreapp.data.remote.Recipe.RecipesNetworkEntity
import com.im.cookgaloreapp.data.remote.Recipe.RecipesNetworkResponse
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.domain.util.EntityMapper

class RecipesResponseMapper : EntityMapper<RecipesNetworkEntity, Recipes> {

    override fun fromEntity(entity: RecipesNetworkEntity): Recipes {
        return Recipes(
            id =entity.id,
            cooking_instructions = entity.cooking_instructions,
            date_added = entity.date_added,
            date_updated = entity.date_updated,
            description = entity.description,
            featured_image = entity.featured_image,
            ingredients = entity.ingredients,
            long_date_added = entity.long_date_added,
            long_date_updated = entity.long_date_updated,
            publisher = entity.publisher,
            rating = entity.rating,
            source_url =entity.source_url,
            title =entity.title,
        )
    }

    override fun toEntity(model: Recipes): RecipesNetworkEntity {
        TODO("Not yet implemented")
    }

    fun mapFromEntityList(entity: List<RecipesNetworkEntity>): List<Recipes>{
        return entity.map { fromEntity(it) }
    }

}