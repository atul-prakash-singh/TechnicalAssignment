package atulps.com.technicalassignment.viewmodel

import androidx.databinding.ObservableField

/**
 * [ArticleDetailViewModel]
 * @brief ViewModel to supply data to [ArticleDetailActivity]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleDetailViewModel : BaseViewModel() {

    val uri = ObservableField<String>("")
    val imageUrl = ObservableField<String>("")
    val detailAbstract = ObservableField<String>("")
    val title = ObservableField<String>("")
    val byLine = ObservableField<String>("")
    val publishedDate = ObservableField<String>("")
}
