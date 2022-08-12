package com.example.base.remote.data.allphotos

import com.example.base.remote.data.details.DetailsPhotoDto

data class UnsplashResponseItem(
    val alt_description: Any,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: DetailsPhotoDto.Links,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val topic_submissions: TopicSubmissions,
    val updated_at: String,
    val urls: DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.Urls,
    val user: DetailsPhotoDto.RelatedCollections.Result.CoverPhoto.User,
    val width: Int
)