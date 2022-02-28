package com.im.cookgaloreapp.domain.util

interface EntityMapper<Entity, Model> {

    fun fromEntity(entity: Entity): Model

    fun toEntity(model: Model): Entity

}