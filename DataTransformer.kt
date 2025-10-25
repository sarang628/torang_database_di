package com.sarang.torang.di.torang_database_di

import com.sarang.torang.core.database.model.favorite.FavoriteEntity
import com.sarang.torang.core.database.model.feed.FeedEntity
import com.sarang.torang.core.database.model.image.ReviewImageEntity
import com.sarang.torang.core.database.model.like.LikeEntity
import com.sarang.torang.core.database.model.user.UserEntity
import com.sarang.torang.data.remote.response.FavoriteApiModel
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.LikeApiModel
import com.sarang.torang.data.remote.response.RemotePicture

fun FeedApiModel.toFeedEntity(): FeedEntity {
    return FeedEntity(
        reviewId = reviewId,
        userId = user.userId,
        contents = contents,
        rating = rating,
        userName = user.userName,
        likeAmount = like_amount,
        commentAmount = comment_amount,
        restaurantName = restaurant.restaurantName,
        restaurantId = restaurant.restaurantId,
        createDate = this.create_date,
        profilePicUrl = this.user.profilePicUrl
    )
}

fun FeedApiModel.toUserEntity(): UserEntity {
    return UserEntity(
        userId = this.user.userId,
        email = this.user.email ?: "",
        loginPlatform = this.user.loginPlatform ?: "",
        createDate = this.user.createDate ?: "",
        accessToken = "",
        profilePicUrl = this.user.profilePicUrl,
        point = 0,
        reviewCount = "0",
        following = "0",
        followers = "0",
        userName = this.user.userName
    )
}

fun LikeApiModel.toLikeEntity(): LikeEntity {
    return LikeEntity(
        likeId = likeId,
        userId = userId,
        createDate = createDate,
        reviewId = reviewId
    )
}

fun FavoriteApiModel.toFavoriteEntity(): FavoriteEntity {
    return FavoriteEntity(
        reviewId = this.review_id,
        favoriteId = this.favorite_id,
        userId = this.user_id,
        createDate = this.create_date
    )
}

fun RemotePicture.toReviewImage(): ReviewImageEntity {
    return ReviewImageEntity(
        pictureId = this.picture_id,
        restaurantId = this.restaurant_id,
        userId = this.user_id,
        reviewId = this.review_id,
        pictureUrl = this.picture_url,
        createDate = this.create_date ?: "",
        menuId = this.menu_id,
        menu = 1,
        width = this.width,
        height = this.height
    )
}