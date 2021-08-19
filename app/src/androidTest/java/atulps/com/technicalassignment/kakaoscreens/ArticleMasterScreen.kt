package atulps.com.technicalassignment.kakaoscreens

import android.view.View
import atulps.com.technicalassignment.R
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.progress.KProgressBar
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher

/**
 * [ArticleMasterScreen]
 * @brief Kakao Screen for [ArticleMasterActivity]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleMasterScreen : Screen<ArticleMasterScreen>() {

    val progressBar = KProgressBar { withId(R.id.progress_bar) }

    val recyclerView = KRecyclerView({
        withId(R.id.recycler_view)
        isDisplayed()
    }, itemTypeBuilder = {
        itemType(::ArticleMasterItem)
    })

    /**
     * [ArticleMasterItem]
     * @brief View Holder Items for each article
     * @author atul.ps
     * @date 03/27/2019
     */
    class ArticleMasterItem(parent: Matcher<View>) : KRecyclerItem<ArticleMasterItem>(parent) {

        val icon = KImageView(parent) { withId(R.id.icon) }

        val arrow = KImageView(parent) { withId(R.id.arrow) }

        val title = KTextView(parent) { withId(R.id.title) }

        val byLine = KTextView(parent) { withId(R.id.by_line) }

        val iconDate = KImageView(parent) { withId(R.id.icon_date) }

        val publishedDate = KTextView(parent) { withId(R.id.published_date) }
    }
}
