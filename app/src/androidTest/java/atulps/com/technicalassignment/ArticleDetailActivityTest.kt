package atulps.com.technicalassignment

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until.hasObject
import atulps.com.technicalassignment.kakaoscreens.ArticleDetailScreen
import atulps.com.technicalassignment.ui.ArticleDetailActivity
import atulps.com.technicalassignment.utility.Constants
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticleDetailActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(ArticleDetailActivity::class.java, true, false)

    private val screen = ArticleDetailScreen()

    @Test
    fun testUIElements() {
        UiDevice.getInstance(getInstrumentation()).wait(hasObject(By.text(DETAIL_ABSTRACT).depth(0)), DELAY)

        screen {
            imageLarge {
                isDisplayed()
                hasDrawable(R.drawable.rectangular_placeholder)
            }
            title {
                isCompletelyDisplayed()
                hasText(TITLE)
                hasTextColor(R.color.colorGrey)
            }
            title {
                isCompletelyDisplayed()
                hasText(TITLE)
                hasTextColor(R.color.colorGrey)
            }
            byLine {
                isCompletelyDisplayed()
                hasText(BYLINE)
                hasTextColor(R.color.colorDarkGrey)
            }
            publishedDate {
                isCompletelyDisplayed()
                hasText(PUBLISHED_DATE)
                hasTextColor(R.color.colorDarkGrey)
            }
            articleAbstract {
                isCompletelyDisplayed()
                hasText(DETAIL_ABSTRACT)
                hasTextColor(R.color.colorGrey)
            }
        }
    }

    @Before
    fun setup() {
        rule.launchActivity(Intent().apply {
            putExtra(Constants.BUNDLE_KEY_URL, IMAGE_LARGE)
            putExtra(Constants.BUNDLE_KEY_TITLE, TITLE)
            putExtra(Constants.BUNDLE_KEY_BY_LINE, BYLINE)
            putExtra(Constants.BUNDLE_KEY_ABSTRACT, DETAIL_ABSTRACT)
            putExtra(Constants.BUNDLE_KEY_PUBLISHED_DATE, PUBLISHED_DATE)
        })
    }

    companion object {
        private const val DELAY = 1000L
        private const val TITLE = "TITLE"
        private const val BYLINE = "BYLINE"
        private const val DETAIL_ABSTRACT = "DETAIL_ABSTRACT"
        private const val PUBLISHED_DATE = "PUBLISHED_DATE"
        private const val IMAGE_LARGE = "IMAGE_LARGE"
    }
}