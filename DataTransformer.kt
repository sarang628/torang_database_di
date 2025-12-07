package com.sarang.torang.di.torang_database_di

import com.sarang.torang.core.database.model.chat.ChatMessageEntity
import com.sarang.torang.core.database.model.chat.ChatParticipantsEntity
import com.sarang.torang.core.database.model.chat.ChatRoomEntity
import com.sarang.torang.core.database.model.favorite.FavoriteEntity
import com.sarang.torang.core.database.model.feed.FeedEntity
import com.sarang.torang.core.database.model.image.ReviewImageEntity
import com.sarang.torang.core.database.model.like.LikeEntity
import com.sarang.torang.core.database.model.user.UserEntity
import com.sarang.torang.data.remote.response.ChatApiModel
import com.sarang.torang.data.remote.response.ChatRoomApiModel
import com.sarang.torang.data.remote.response.FavoriteApiModel
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.LikeApiModel
import com.sarang.torang.data.remote.response.RemotePicture
import kotlin.String

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
        reviewCount = this.user.post.toString(),
        following = this.user.following.toString(),
        followers = this.user.follower.toString(),
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

val ChatRoomApiModel.chatRoomEntity : ChatRoomEntity get() =
    ChatRoomEntity(
        roomId = this.roomId,
        createDate = this.createDate
    )

val List<ChatRoomApiModel>.chatRoomEntityList : List<ChatRoomEntity> get() =
    this.map { it.chatRoomEntity }

val List<ChatRoomApiModel>.chatParticipantsEntityList : List<ChatParticipantsEntity> get() =
    this.flatMap { room ->
        room.users.map {
            ChatParticipantsEntity(roomId = room.roomId, userId = it.userId)
        }
    }

val List<ChatRoomApiModel>.users : List<UserEntity> get() =
    this.flatMap { room ->
        room.users.map {
            UserEntity(
                userId = it.userId,
                userName = it.userName,
                email = "",
                loginPlatform = "",
                createDate = "",
                accessToken = "",
                profilePicUrl = it.profilePicUrl,
                point = 0,
                reviewCount = "",
                followers = "",
                following = ""
            )
        }
    }

val List<ChatApiModel>.chats : List<ChatMessageEntity> get() =
    this.map {
        ChatMessageEntity(
            uuid = it.uuid,
            roomId = it.roomId,
            userId = it.userId,
            message = it.message,
            createDate = it.createDate,
            sending = false,
        )
    }