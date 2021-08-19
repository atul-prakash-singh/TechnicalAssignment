package atulps.com.technicalassignment.kakaoscreens

import atulps.com.technicalassignment.R
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView

/**
 * [ArticleDetailScreen]
 * @brief Kakao Screen for [ArticleDetailActivity]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleDetailScreen : Screen<ArticleDetailScreen>() {

    val imageLarge = KImageView { withId(R.id.image_large) }

    val title = KTextView { withId(R.id.title) }

    val byLine = KTextView { withId(R.id.by_line) }

    val articleAbstract = KTextView { withId(R.id.article_abstract) }

    val publishedDate = KTextView { withId(R.id.published_date) }
}
