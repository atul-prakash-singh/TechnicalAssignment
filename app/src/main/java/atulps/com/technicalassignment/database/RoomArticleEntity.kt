package atulps.com.technicalassignment.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [RoomArticleEntity]
 * @brief Data class to manage Articles Screen
 * @author asingh
 * @date 03/27/2019
 */
@Entity(tableName = "article_table")
data class RoomArticleEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "url")
    var url: String = "",

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "byline")
    var byLine: String = "",

    @ColumnInfo(name = "detail_abstract")
    var detailAbstract: String = "",

    @ColumnInfo(name = "published_date")
    var publishedDate: String = "",

    @ColumnInfo(name = "image_thumbnail")
    var imageThumbnail: String = "",

    @ColumnInfo(name = "image_large")
    var imageLarge: String = ""
)
