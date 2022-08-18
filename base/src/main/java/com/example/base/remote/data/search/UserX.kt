package com.example.base.remote.data.search

import com.example.base.remote.data.details.DetailsPhotoDto

data class UserX(
    val accepted_tos: Boolean = false,
    val bio: String = "",
    val first_name: String = "",
    val for_hire: Boolean = false,
    val id: String = "",
    val instagram_username: String = "",
    val last_name: String = "",
    val links: LinksXXX = LinksXXX(),
    val location: String = "",
    val name: String = "",
    val portfolio_url: String = "",
    val profile_image: DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.User.ProfileImageX = DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.User.ProfileImageX(),
    val social: DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.User.SocialX = DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.User.SocialX(),
    val total_collections: Int = 0,
    val total_likes: Int = 0,
    val total_photos: Int = 0,
    val twitter_username: String = "",
    val updated_at: String = "",
    val username: String = ""
){
    data class LinksXXX(
        val followers: String = "",
        val following: String = "",
        val html: String = "",
        val likes: String = "",
        val photos: String = "",
        val portfolio: String = "",
        val self: String = ""
    )
}