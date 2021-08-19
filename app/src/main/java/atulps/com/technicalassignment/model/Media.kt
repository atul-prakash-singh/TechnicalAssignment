package atulps.com.technicalassignment.model

import com.google.gson.annotations.SerializedName

/**
 * [Media]
 * @brief Model Data class to hold remote api response from Retrofit Service
 * @author atul.ps
 * @date 03/27/2019
 */
data class Media(

    @SerializedName("copyright")
    val copyRight:  String,

    @SerializedName(value = "media-metadata")
    val metaData: List<Image>
)
