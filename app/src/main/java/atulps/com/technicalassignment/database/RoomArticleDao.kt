package atulps.com.technicalassignment.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query

/**
 * [RoomBaseDao]
 * @brief Abstract class provides the basic CRUD operations for Room Database.
 * Room library generates the implementation for the methods during build.
 * @author: atul.ps
 * @date: 03/27/2019
 */
@Dao
abstract class RoomArticleDao : RoomBaseDao<RoomArticleEntity>() {

    /**
     * [getArticles]
     * @brief Dao method to fetch most popular articles from DB
     * @return DataSource.Factory<Int, RoomArticleEntity>
     * @author asingh
     * @date 03/27/2019
     */
    @Query("SELECT * FROM article_table")
    abstract fun getArticles(): DataSource.Factory<Int, RoomArticleEntity>

    /**
     * [getArticleCount]
     * @brief Dao method to get most popular articles Count from DB
     * @return Int
     * @author asingh
     * @date 03/27/2019
     */
    @Query("SELECT COUNT(id) from article_table")
    abstract fun getArticleCount() : Int
}
