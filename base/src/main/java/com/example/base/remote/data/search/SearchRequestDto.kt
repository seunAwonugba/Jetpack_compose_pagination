package com.example.base.remote.data.search

import com.example.base.remote.data.details.DetailsPhotoDto

data class SearchRequestDto(
    val results: List<Result> = emptyList(),
    val total: Int,
    val total_pages: Int
){
    data class Result(
        val alt_description: String = "",
        val blur_hash: String = "",
        val categories: List<String> = emptyList(),
        val color: String = "",
        val created_at: String = "",
        val current_user_collections: List<String>  = emptyList(),
        val description: String = "",
        val height: Int  = 0,
        val id: String = "",
        val liked_by_user: Boolean = false,
        val likes: Int = 0,
        val links: DetailsPhotoDto.Links = DetailsPhotoDto.Links(),
        val promoted_at: String = "",
        val sponsorship: String = "",
        val tags: List<DetailsPhotoDto.RelatedCollections.Result.Tag> = emptyList(),
        val topic_submissions: TopicSubmissionsX = TopicSubmissionsX(),
        val updated_at: String = "",
        val urls: DetailsPhotoDto.RelatedCollections.Result.PreviewPhoto.UrlsX,
        val user: UserX = UserX(),
        val width: Int = 0
    ){
        data class TopicSubmissionsX(
            val health: HealthX = HealthX()
        ){
            data class HealthX(
                val approved_on: String = "",
                val status: String = ""
            )
        }

    }
}