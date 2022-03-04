package com.im.cookgaloreapp.data.local.util

import com.im.cookgaloreapp.data.local.bookmark.BookmarkCacheEntity
import com.im.cookgaloreapp.data.local.favourites.FavouritesCacheEntity
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.domain.util.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouritesCacheMapper : EntityMapper<FavouritesCacheEntity, Recipes> {

    override fun fromEntity(entity: FavouritesCacheEntity):Recipes {
        return Recipes(
            id = entity.id,
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
            source_url = entity.source_url,
            title = entity.title,
        )
    }

    override fun toEntity(model: Recipes): FavouritesCacheEntity {
        return FavouritesCacheEntity(
            id = model.id,
            cooking_instructions = model.cooking_instructions,
            date_added = model.date_added,
            date_updated = model.date_updated,
            description = model.description,
            featured_image = model.featured_image,
            ingredients = model.ingredients,
            long_date_added = model.long_date_added,
            long_date_updated = model.long_date_updated,
            publisher = model.publisher,
            rating = model.rating,
            source_url = model.source_url,
            title = model.title,
        )
    }

    fun mapFromEntityList(entity: List<FavouritesCacheEntity>): List<Recipes> {
        return entity.map { fromEntity(it) }
    }

    fun mapFromEntityFlowList(entity: Flow<List<FavouritesCacheEntity>>): Flow<List<Recipes>> {
        return entity.map { mapFromEntityList(it) }
    }

}