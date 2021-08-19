package atulps.com.technicalassignment.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import atulps.com.technicalassignment.R
import atulps.com.technicalassignment.databinding.ActivityArticleDetailBinding
import atulps.com.technicalassignment.utility.Constants
import atulps.com.technicalassignment.viewmodel.ArticleDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * [ArticleDetailActivity]
 * @brief Activity class to show Most Popular News Article Details
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityArticleDetailBinding

    private lateinit var viewModel: ArticleDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apply {
            imageUrl.set(intent.extras?.getString(Constants.BUNDLE_KEY_URL) ?: "")
            title.set(intent.extras?.getString(Constants.BUNDLE_KEY_TITLE) ?: "")
            byLine.set(intent.extras?.getString(Constants.BUNDLE_KEY_BY_LINE) ?: "")
            detailAbstract.set(intent.extras?.getString(Constants.BUNDLE_KEY_ABSTRACT) ?: "")
            publishedDate.set(intent.extras?.getString(Constants.BUNDLE_KEY_PUBLISHED_DATE) ?: "")
        }
    }

    override fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_detail)

        viewModel = ArticleDetailViewModel()
        binding.viewModel = viewModel
    }
}
