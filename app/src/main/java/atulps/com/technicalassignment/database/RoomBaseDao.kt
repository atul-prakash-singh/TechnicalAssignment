package atulps.com.technicalassignment.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * [RoomBaseDao]
 * @brief Abstract class provides the basic CRUD operations for Room Database.
 * Room library generates the implementation for the methods during build.
 * @author: atul.ps
 * @date: 03/27/2019
 */
@Dao
abstract class RoomBaseDao<T> {

    /**
     * [insertEntity]
     * @brief Abstract function to insert entity in the database with replace strategy
     * @author: atul.ps
     * @date: 03/27/2019
     * @param [item] T
     * @return [Long] row Id of the inserted record
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertEntity(item: T): Long

    /**
     * [updateEntity]
     * @brief Abstract function to update entity in the database
     * @author: atul.ps
     * @date: 03/27/2019
     * @param [item] T
     * @return [Int] number of rows affected by update
     */
    @Update
    abstract fun updateEntity(item: T): Int

    /**
     * [deleteEntity]
     * @brief Abstract function to delete entity from the database
     * @author: atul.ps
     * @date: 03/27/2019
     * @param [item] T
     */
    @Delete
    abstract fun deleteEntity(item: T)
}
