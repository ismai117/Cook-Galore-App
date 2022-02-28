package com.im.cookgaloreapp.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.im.cookgaloreapp.domain.Recipes.Recipes


class AssetParamType : NavType<Recipes>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): Recipes? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Recipes {
        return Gson().fromJson(value, Recipes::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Recipes) {
        bundle.putParcelable(key, value)
    }

}
