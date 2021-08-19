package atulps.com.technicalassignment.model

import com.google.gson.annotations.SerializedName

/**
 * [Results]
 * @brief Model Data class to hold remote api response from Retrofit Service
 * @author atul.ps
 * @date 03/27/2019
 */
data class Results(

    @SerializedName("results")
    val articles: List<Article>
)
