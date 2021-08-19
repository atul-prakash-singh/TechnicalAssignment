package atulps.com.technicalassignment.database

import android.annotation.SuppressLint
import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * [RoomArticleDatabase]
 * @brief RoomDatabase class from android. It contains abstract methods to get
 * Dao objects corresponding table. See DataBaseModule class for getting the instance of this class.
 * @author atul.ps
 * @date: 03/27/2019
 */
@Database(
    entities = [
        RoomArticleEntity::class
    ], version = 1, exportSchema = false
)
@SuppressLint("SyntheticAccessor")
abstract class RoomArticleDatabase : RoomDatabase() {

    /**
     * [articleDao]
     * @brief Abstract Function to return [RoomArticleDao] instance
     * @return: RoomArticleDao
     * @date: 03/27/2019
     * @author: atul.ps
     * */
    abstract fun articleDao(): RoomArticleDao
}
