package com.im.cookgaloreapp.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.im.cookgaloreapp.domain.Recipes.Recipes
import com.im.cookgaloreapp.repository.bookmark.BookmarkRepository_Impl
import com.im.cookgaloreapp.repository.recipe.RecipeRepository_Impl
import com.im.cookgaloreapp.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val recipeRepositoryImpl: RecipeRepository_Impl,
    private val bookmarkRepositoryImpl: BookmarkRepository_Impl
) : ViewModel() {

    private val Authorization = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"

    private val _recipes = MutableStateFlow<ViewState>(ViewState.Success(emptyList()))
    val recipes: StateFlow<ViewState> = _recipes

    val query = mutableStateOf("")

    private val _categories: MutableState<List<RecipeCategory>> = mutableStateOf(listOf())
    val categories: MutableState<List<RecipeCategory>> = _categories

    init {
        viewModelScope.launch {
            delay(2000)
            getRecipeCategories()
        }
    }

    fun searchRecipes(query: String){

        viewModelScope.launch(Dispatchers.IO) {


            _recipes.value = ViewState.Loading

            try {

                val response = recipeRepositoryImpl
                    .searchRecipes(
                        auth = Authorization,
                        page = 1,
                        query = query
                    )

                if (response.isNullOrEmpty()){
                    _recipes.value = ViewState.Empty
                }else{
                    _recipes.value = ViewState.Success(response)
                }

            } catch (exception: Exception){

                _recipes.value = ViewState.Error(exception)

            }

        }

    }

    private fun getRecipeCategories(){

        _categories.value = RecipeCategory.values().toList()

    }

    fun insertBookmark(bookmark: Recipes){
        viewModelScope.launch {
            bookmarkRepositoryImpl.insertBookmark(bookmark = bookmark)
        }
    }

    fun ifBookmarkExists(bookmark: Int): Flow<Int> {
        return bookmarkRepositoryImpl.ifBookmarkExists(bookmark = bookmark)
    }


    fun onChangedQuery(query: String){
        this.query.value = query
    }


}



enum class RecipeCategory(val value: String){
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}