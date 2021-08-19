package atulps.com.technicalassignment.model

import com.google.gson.annotations.SerializedName

/**
 * [Image]
 * @brief Model Data class to hold remote api response from Retrofit Service
 * @author atul.ps
 * @date 03/27/2019
 */
data class Image(

    @SerializedName(value = "url")
    val url: String,

    @SerializedName(value = "format")
    val format: String
)
