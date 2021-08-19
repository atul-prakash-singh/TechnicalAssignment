package atulps.com.technicalassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import atulps.com.technicalassignment.IArticleClickListener
import atulps.com.technicalassignment.R
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.ui.adapter.viewholder.ArticleMasterViewHolder
import atulps.com.technicalassignment.viewmodel.ArticleMasterItemViewModel

/**
 * [ArticleMasterAdapter]
 * @brief PagedListAdapter to display Most Popular Articles in RecyclerView
 * @author asingh
 * @date 03/27/2019
 */
class ArticleMasterAdapter(
    private val inflater: LayoutInflater,
    private val clickListener: IArticleClickListener
) : PagedListAdapter<RoomArticleEntity, RecyclerView.ViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ArticleMasterViewHolder(
            inflater.inflate(R.layout.item_article, parent, false),
            ArticleMasterItemViewModel(),
            clickListener)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val record = getItem(position)
        if (record != null)
            (holder as ArticleMasterViewHolder).setItem(record)
    }

    companion object {

        private val diffCallBack =
            object : DiffUtil.ItemCallback<RoomArticleEntity>() {
                override fun areItemsTheSame(
                    oldItem: RoomArticleEntity,
                    newItem: RoomArticleEntity
                ) = oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: RoomArticleEntity,
                    newItem: RoomArticleEntity
                ) = oldItem == newItem
            }
    }
}
