package com.sarang.torang.di.torang_database_di

import com.sarang.torang.core.database.AppDatabase
import com.sarang.torang.core.database.dao.ChatDao
import com.sarang.torang.core.database.dao.CommentDao
import com.sarang.torang.core.database.dao.FavoriteDao
import com.sarang.torang.core.database.dao.FeedDao
import com.sarang.torang.core.database.dao.LikeDao
import com.sarang.torang.core.database.dao.LoggedInUserDao
import com.sarang.torang.core.database.dao.MyFeedDao
import com.sarang.torang.core.database.dao.PictureDao
import com.sarang.torang.core.database.dao.RestaurantDao
import com.sarang.torang.core.database.dao.RestaurantImageDao
import com.sarang.torang.core.database.dao.ReviewDao
import com.sarang.torang.core.database.dao.SearchedRestaurantDao
import com.sarang.torang.core.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DaoModules {
    @Provides fun loggedInUserDao       (appDatabase: AppDatabase): LoggedInUserDao         { return appDatabase.LoggedInUserDao() }
    @Provides fun feedDao               (appDatabase: AppDatabase): FeedDao                 { return appDatabase.feedDao() }
    @Provides fun pictureDao            (appDatabase: AppDatabase): PictureDao              { return appDatabase.pictureDao() }
    @Provides fun userDao               (appDatabase: AppDatabase): UserDao                 { return appDatabase.userDao() }
    @Provides fun likeDao               (appDatabase: AppDatabase): LikeDao                 { return appDatabase.likeDao() }
    @Provides fun favoriteDao           (appDatabase: AppDatabase): FavoriteDao             { return appDatabase.favoriteDao() }
    @Provides fun reviewDao             (appDatabase: AppDatabase): ReviewDao               { return appDatabase.reviewDao() }
    @Provides fun restaurantDao         (appDatabase: AppDatabase): RestaurantDao           { return appDatabase.restaurantDao() }
    @Provides fun commentDao            (appDatabase: AppDatabase): CommentDao              { return appDatabase.commentDao() }
    @Provides fun myFeedDao             (appDatabase: AppDatabase): MyFeedDao               { return appDatabase.myFeedDao() }
    @Provides fun chatDao               (appDatabase: AppDatabase): ChatDao                 { return appDatabase.chatDao() }
    @Provides fun searchedRestaurantDao (appDatabase: AppDatabase): SearchedRestaurantDao   { return appDatabase.searchedRestaurantDao() }
    @Provides fun restaurantImageDao    (appDatabase: AppDatabase): RestaurantImageDao      { return appDatabase.restaurantImageDao() }
}