package atulps.com.technicalassignment.model

import com.google.gson.annotations.SerializedName

/**
 * [Article]
 * @brief Model Data class to hold remote api response from Retrofit Service
 * @author atul.ps
 * @date 03/27/2019
 */
data class Article(

    @SerializedName(value = "id")
    val id: Long,

    @SerializedName(value = "url")
    val url: String,

    @SerializedName(value = "byline")
    val byLine: String,

    @SerializedName(value = "title")
    val title: String,

    @SerializedName(value = "abstract")
    val detailAbstract: String,

    @SerializedName(value = "published_date")
    val publishedDate: String,

    @SerializedName(value = "media")
    val media: List<Media>
)
