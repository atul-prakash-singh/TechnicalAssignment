package atulps.com.technicalassignment

import atulps.com.technicalassignment.database.RoomArticleEntity

/**
 * [IArticleClickListener]
 * @brief Interface to Listen Item Click Event.
 * @author atul.ps
 * @date 03/27/2019
 */
interface IArticleClickListener {

    /**
     * [onItemClick]
     * @brief Function to be get called when article recycler view item is clicked.
     * @param [item] RoomArticleEntity
     * @author atul.ps
     * @date 03/27/2019
     */
    fun onItemClick(item: RoomArticleEntity)
}
