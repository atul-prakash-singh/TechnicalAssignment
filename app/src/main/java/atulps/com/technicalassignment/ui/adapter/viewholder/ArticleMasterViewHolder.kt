package atulps.com.technicalassignment.ui.adapter.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import atulps.com.technicalassignment.IArticleClickListener
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.databinding.ItemArticleBinding
import atulps.com.technicalassignment.utility.EventIdentifier
import atulps.com.technicalassignment.viewmodel.ArticleMasterItemViewModel

/**
 * [ArticleMasterViewHolder]
 * @brief ViewHolder class to manage recycler view Article Items
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleMasterViewHolder(
    view: View,
    private val viewModel: ArticleMasterItemViewModel,
    private val listener: IArticleClickListener
) : RecyclerView.ViewHolder(view) {

    private val binding: ItemArticleBinding? = DataBindingUtil.bind(view)
    private lateinit var item: RoomArticleEntity

    init {
        binding?.viewModel = viewModel
        setUpViewModelEventListener()
    }

    /**
     * [setItem]
     * @brief Will set view model properties
     * @param [item] RoomArticleEntity
     * @author asingh
     * @date 03/27/2019
     */
    fun setItem(item: RoomArticleEntity) {

        this.item = item

        viewModel.apply {
            uri.set(item.imageThumbnail)
            title.set(item.title)
            byLine.set(item.byLine)
            publishedDate.set(item.publishedDate)
        }
    }


    /**
     * [setUpViewModelEventListener]
     * @brief Will listen to events from view model
     * @author asingh
     * @date 03/27/2019
     */
    private fun setUpViewModelEventListener() {
        viewModel.onEventReceived += { et ->
            if (et.type == EventIdentifier.ARTICLE_LIST_ITEM_CLICKED)
                listener.onItemClick(item)
        }
    }
}
