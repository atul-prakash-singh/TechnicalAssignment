package atulps.com.technicalassignment.viewmodel

import androidx.databinding.ObservableField
import atulps.com.technicalassignment.ui.adapter.viewholder.ArticleMasterViewHolder
import atulps.com.technicalassignment.utility.EventIdentifier

/**
 * [ArticleMasterItemViewModel]
 * @brief ViewModel to supply data to [ArticleMasterViewHolder]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleMasterItemViewModel : BaseViewModel() {

    val uri = ObservableField<String>("")
    val title = ObservableField<String>("")
    val byLine = ObservableField<String>("")
    val publishedDate = ObservableField<String>("")

    /**
     * [onItemClick]
     * @brief Will get triggered from xml on click event
     * @author atul.ps
     * @date 03/27/2019
     */
    fun onItemClick() = triggerEvent(EventIdentifier.ARTICLE_LIST_ITEM_CLICKED)
}
