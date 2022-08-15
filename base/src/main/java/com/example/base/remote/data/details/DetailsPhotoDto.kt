package com.example.base.remote.data.details

import com.example.base.ui.DetailsPhoto
import com.google.gson.annotations.SerializedName

data class DetailsPhotoDto(
    val alt_description: String = "",
    val blur_hash: String= "",
    val categories: List<String> = emptyList(),
    val color: String= "",
    val created_at: String= "",
    val current_user_collections: List<String> = emptyList(),
    val description: String= "",
    val downloads: Int= 0,
    val exif: Exif = Exif(),
    val height: Int= 0,
    val id: String = "",
    val liked_by_user: Boolean= false,
    val likes: Int= 0,
    val links: Links = Links(),
    val location: Location,
    val meta: Meta = Meta(),
    val promoted_at: String= "",
    val public_domain: Boolean= false,
    val related_collections: RelatedCollections,
    val sponsorship: Sponsorship,
    val tags: List<TagX> = emptyList(),
    val tags_preview: List<TagsPreview> = emptyList(),
    val topic_submissions: TopicSubmissionsXX,
    val topics: List<Topic> = emptyList(),
    val updated_at: String= "",
    val urls: UrlsXXX = UrlsXXX(),
    val user: UserXXX = UserXXX(),
    val views: Int= 0,
    val width: Int= 0
){

    data class Exif(
        val aperture: String = "",
        val exposure_time: String= "",
        val focal_length: String= "",
        val iso: Int= 0,
        val make: String= "",
        val model: String= "",
        val name: String= ""
    )


    data class Links(
        val download: String= "",
        val download_location: String= "",
        val html: String= "",
        val self: String= ""
    )

    data class Location(
        val city: String= "",
        val country: String= "",
        val name: String= "",
        val position: Position,
        val title: String= ""
    ){
        data class Position(
            val latitude: String= "",
            val longitude: String= ""
        )
    }

    data class Meta(
        val index: Boolean= false
    )


    data class RelatedCollections(
        val results: List<Result>,
        val total: Int= 0,
        val type: String= ""
    ){

        data class Result(
            val cover_photo: CoverPhoto,
            val curated: Boolean= false,
            val description: String,
            val featured: Boolean= false,
            val id: String= "",
            val last_collected_at: String= "",
            val links: LinksXXX= LinksXXX(),
            val preview_photos: List<PreviewPhoto> = emptyList(),
            val `private`: Boolean= false,
            val published_at: String= "",
            val share_key: String= "",
            val tags: List<Tag> = emptyList(),
            val title: String= "",
            val total_photos: Int= 0,
            val updated_at: String= "",
            val user: UserXX = UserXX()
        ){
            data class CoverPhoto(
                val alt_description: String= "",
                val blur_hash: String= "",
                val categories: List<String>,
                val color: String= "",
                val created_at: String= "",
                val current_user_collections: List<String> = emptyList(),
                val description: String= "",
                val height: Int= 0,
                val id: String= "",
                val liked_by_user: Boolean= false,
                val likes: Int= 0,
                val links: LinksX = LinksX(),
                val promoted_at: String= "",
                val sponsorship: String,
                val topic_submissions: TopicSubmissions = TopicSubmissions(),
                val updated_at: String= "",
                val urls: Urls = Urls(),
                val user: User = User(),
                val width: Int= 0
            ){

                data class LinksX(
                    val download: String= "",
                    val download_location: String= "",
                    val html: String= "",
                    val self: String= ""
                )

                data class TopicSubmissions(
                    @SerializedName("business-work")
                    val business_work: BusinessWork = BusinessWork(),
                    @SerializedName("covid-19")
                    val covid_19: Covid19 = Covid19(),
                    @SerializedName("current-events")
                    val current_events: CurrentEvents = CurrentEvents(),
                    val people: People = People(),
                    @SerializedName("work-from-home")
                    val work_from_home: WorkFromHome = WorkFromHome()
                ){

                    data class BusinessWork(
                        val approved_on: String= "",
                        val status: String= ""
                    )


                    data class Covid19(
                        val approved_on: String= "",
                        val status: String= ""
                    )


                    data class CurrentEvents(
                        val approved_on: String= "",
                        val status: String= ""
                    )


                    data class People(
                        val approved_on: String= "",
                        val status: String= ""
                    )


                    data class WorkFromHome(
                        val approved_on: String= "",
                        val status: String= ""
                    )
                }


                data class Urls(
                    val full: String = "",
                    val raw: String = "",
                    val regular: String = "",
                    val small: String = "",
                    val small_s3: String = "",
                    val thumb: String = ""
                )

                data class User(
                    val accepted_tos: Boolean = false,
                    val bio: String = "",
                    val first_name: String = "",
                    val for_hire: Boolean = false,
                    val id: String = "",
                    val instagram_username: String = "",
                    val last_name: String = "",
                    val links: LinksXX = LinksXX(),
                    val location: String = "",
                    val name: String = "",
                    val portfolio_url: String = "",
                    val profile_image: ProfileImageX  = ProfileImageX(),
                    val social: SocialX = SocialX(),
                    val total_collections: Int = 0,
                    val total_likes: Int = 0,
                    val total_photos: Int = 0,
                    val twitter_username: Any = 0,
                    val updated_at: String = "",
                    val username: String = ""
                ){

                    data class LinksXX(
                        val followers: String = "",
                        val following: String = "",
                        val html: String = "",
                        val likes: String = "",
                        val photos: String = "",
                        val portfolio: String = "",
                        val self: String = ""
                    )


                    data class ProfileImageX(
                        val large: String = "",
                        val medium: String = "",
                        val small: String = ""
                    )


                    data class SocialX(
                        val instagram_username: String = "",
                        val paypal_email: Any = "",
                        val portfolio_url: String = "",
                        val twitter_username: Any = ""
                    )
                }
            }


            data class LinksXXX(
                val html: String= "",
                val photos: String= "",
                val related: String= "",
                val self: String= ""
            )


            data class PreviewPhoto(
                val blur_hash: String= "",
                val created_at: String= "",
                val id: String= "",
                val updated_at: String= "",
                val urls: UrlsX
            ){

                data class UrlsX(
                    val full: String= "",
                    val raw: String= "",
                    val regular: String= "",
                    val small: String= "",
                    val small_s3: String= "",
                    val thumb: String= ""
                )
            }


            data class Tag(
                val source: Source = Source(),
                val title: String= "",
                val type: String= ""
            ){

                data class Source(
                    val ancestry: Ancestry = Ancestry(),
                    val cover_photo: CoverPhotoX = CoverPhotoX(),
                    val description: String= "",
                    val meta_description: String= "",
                    val meta_title: String= "",
                    val subtitle: String= "",
                    val title: String= ""
                ){
                    data class Ancestry(
                        val category: Category = Category(),
                        val subcategory: Subcategory = Subcategory(),
                        val type: Type = Type()
                    ){

                        data class Category(
                            val pretty_slug: String= "",
                            val slug: String= ""
                        )


                        data class Subcategory(
                            val pretty_slug: String= "",
                            val slug: String= ""
                        )


                        data class Type(
                            val pretty_slug: String= "",
                            val slug: String= ""
                        )
                    }

                    data class CoverPhotoX(
                        val alt_description: String= "",
                        val blur_hash: String= "",
                        val categories: List<String> = emptyList(),
                        val color: String= "",
                        val created_at: String= "",
                        val current_user_collections: List<String> = emptyList(),
                        val description: String= "",
                        val height: Int= 0,
                        val id: String= "",
                        val liked_by_user: Boolean= false,
                        val likes: Int= 0,
                        val links: LinksXXXX = LinksXXXX(),
                        val promoted_at: String= "",
                        val sponsorship: String= "",
                        val topic_submissions: TopicSubmissionsX = TopicSubmissionsX(),
                        val updated_at: String= "",
                        val urls: UrlsXX = UrlsXX(),
                        val user: UserX = UserX(),
                        val width: Int= 0
                    ){

                        data class LinksXXXX(
                            val download: String= "",
                            val download_location: String= "",
                            val html: String= "",
                            val self: String= ""
                        )


                        data class TopicSubmissionsX(
                            @SerializedName("current-events")
                            val current_events: CurrentEventsX = CurrentEventsX(),
                            val monochrome: Monochrome = Monochrome(),
                            @SerializedName("textures-patterns")
                            val textures_patterns: TexturesPatterns = TexturesPatterns(),
                            val wallpapers: Wallpapers = Wallpapers()
                        ){

                            data class CurrentEventsX(
                                val approved_on: String= "",
                                val status: String= ""
                            )


                            data class Monochrome(
                                val status: String= ""
                            )


                            data class TexturesPatterns(
                                val approved_on: String= "",
                                val status: String= ""
                            )


                            data class Wallpapers(
                                val status: String= ""
                            )
                        }


                        data class UrlsXX(
                            val full: String= "",
                            val raw: String= "",
                            val regular: String= "",
                            val small: String= "",
                            val small_s3: String= "",
                            val thumb: String= ""
                        )

                        data class UserX(
                            val accepted_tos: Boolean= false,
                            val bio: String= "",
                            val first_name: String= "",
                            val for_hire: Boolean= false,
                            val id: String= "",
                            val instagram_username: String= "",
                            val last_name: String= "",
                            val links: LinksXXXXX = LinksXXXXX(),
                            val location: String= "",
                            val name: String= "",
                            val portfolio_url: String= "",
                            val profile_image: ProfileImageX = ProfileImageX(),
                            val social: SocialX = SocialX(),
                            val total_collections: Int= 0,
                            val total_likes: Int= 0,
                            val total_photos: Int= 0,
                            val twitter_username: String= "",
                            val updated_at: String= "",
                            val username: String= ""
                        ){

                            data class LinksXXXXX(
                                val followers: String= "",
                                val following: String= "",
                                val html: String= "",
                                val likes: String= "",
                                val photos: String= "",
                                val portfolio: String= "",
                                val self: String= ""
                            )


                            data class ProfileImageX(
                                val large: String= "",
                                val medium: String= "",
                                val small: String= ""
                            )


                            data class SocialX(
                                val instagram_username: String= "",
                                val paypal_email: String= "",
                                val portfolio_url: String= "",
                                val twitter_username: String= ""
                            )
                        }
                    }
                }
            }


            data class UserXX(
                val accepted_tos: Boolean= false,
                val bio: Any= "",
                val first_name: String= "",
                val for_hire: Boolean= false,
                val id: String= "",
                val instagram_username: Any= "",
                val last_name: String= "",
                val links: LinksXXXXXX = LinksXXXXXX(),
                val location: Any= "",
                val name: String= "",
                val portfolio_url: Any= "",
                val profile_image: ProfileImageXX = ProfileImageXX(),
                val social: SocialXX = SocialXX(),
                val total_collections: Int= 0,
                val total_likes: Int= 0,
                val total_photos: Int= 0,
                val twitter_username: Any= "",
                val updated_at: String= "",
                val username: String= ""
            ){
                data class LinksXXXXXX(
                    val followers: String= "",
                    val following: String= "",
                    val html: String= "",
                    val likes: String= "",
                    val photos: String= "",
                    val portfolio: String= "",
                    val self: String= ""
                )

                data class ProfileImageXX(
                    val large: String= "",
                    val medium: String= "",
                    val small: String= ""
                )


                data class SocialXX(
                    val instagram_username: Any= "",
                    val paypal_email: Any= "",
                    val portfolio_url: Any= "",
                    val twitter_username: Any= ""
                )
            }
        }
    }

    data class Sponsorship(
        val impression_urls: List<String> = emptyList(),
        val sponsor: Sponsor = Sponsor(),
        val tagline: String= "",
        val tagline_url: String= ""
    ){

        data class Sponsor(
            val accepted_tos: Boolean= false,
            val bio: String= "",
            val first_name: String= "",
            val for_hire: Boolean= false,
            val id: String= "",
            val instagram_username: String= "",
            val last_name: Any= "",
            val links: LinksXXXXXXX = LinksXXXXXXX(),
            val location: Any= "",
            val name: String= "",
            val portfolio_url: String= "",
            val profile_image: ProfileImageXXX = ProfileImageXXX(),
            val social: SocialXXX = SocialXXX(),
            val total_collections: Int= 0,
            val total_likes: Int= 0,
            val total_photos: Int= 0,
            val twitter_username: String= "",
            val updated_at: String= "",
            val username: String= ""
        ){
            data class LinksXXXXXXX(
                val followers: String= "",
                val following: String= "",
                val html: String= "",
                val likes: String= "",
                val photos: String= "",
                val portfolio: String= "",
                val self: String= ""
            )

            data class ProfileImageXXX(
                val large: String= "",
                val medium: String= "",
                val small: String= ""
            )

            data class SocialXXX(
                val instagram_username: String= "",
                val paypal_email: Any= "",
                val portfolio_url: String= "",
                val twitter_username: String= ""
            )
        }
    }

    data class TagsPreview(
        val title: String= "",
        val type: String= ""
    )


    data class TopicSubmissionsXX(
        val business_work: BusinessWorkX = BusinessWorkX(),
        val covid_19: Covid19X = Covid19X(),
        val current_events: CurrentEventsXX = CurrentEventsXX(),
        val work: Work = Work(),
        val work_from_home: WorkFromHomeX = WorkFromHomeX()
    ){
        data class BusinessWorkX(
            val approved_on: String= "",
            val status: String= ""
        )

        data class Covid19X(
            val approved_on: String= "",
            val status: String= ""
        )

        data class CurrentEventsXX(
            val approved_on: String= "",
            val status: String= ""
        )

        data class Work(
            val approved_on: String= "",
            val status: String= ""
        )

        data class WorkFromHomeX(
            val approved_on: String= "",
            val status: String= ""
        )
    }

    data class Topic(
        val id: String= "",
        val slug: String= "",
        val title: String= "",
        val visibility: String= ""
    )

    data class UrlsXXX(
        val full: String= "",
        val raw: String= "",
        val regular: String= "",
        val small: String= "",
        val small_s3: String= "",
        val thumb: String= ""
    )


    data class UserXXX(
        val accepted_tos: Boolean= false,
        val bio: String= "",
        val first_name: String= "",
        val for_hire: Boolean= false,
        val id: String= "",
        val instagram_username: String= "",
        val last_name: String= "",
        val links: LinksXXXXXXXX = LinksXXXXXXXX(),
        val location: String= "",
        val name: String= "",
        val portfolio_url: String= "",
        val profile_image: ProfileImageXXXX = ProfileImageXXXX(),
        val social: SocialXXXX = SocialXXXX(),
        val total_collections: Int= 0,
        val total_likes: Int= 0,
        val total_photos: Int= 0,
        val twitter_username: String= "",
        val updated_at: String= "",
        val username: String= ""
    ){
        data class LinksXXXXXXXX(
            val followers: String= "",
            val following: String= "",
            val html: String= "",
            val likes: String= "",
            val photos: String= "",
            val portfolio: String= "",
            val self: String= ""
        )

        data class ProfileImageXXXX(
            val large: String= "",
            val medium: String= "",
            val small: String= ""
        )

        data class SocialXXXX(
            val instagram_username: String= "",
            val paypal_email: Any= "",
            val portfolio_url: String= "",
            val twitter_username: String= ""
        )
    }

    data class TagX(
        val title: String= "",
        val type: String= ""
    )
}