package atulps.com.technicalassignment.viewmodel

import atulps.com.technicalassignment.utility.EventIdentifier
import org.junit.Assert
import org.junit.Test

/**
 * [ArticleMasterItemViewModelTest]
 * @brief JUnit test class for [ArticleMasterItemViewModel]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleMasterItemViewModelTest {

    @Test
    fun testOnItemClick() {
        var itemClicked = false

        val viewModel = ArticleMasterItemViewModel()
        viewModel.onEventReceived += { et ->
            when (et.type) {
                EventIdentifier.ARTICLE_LIST_ITEM_CLICKED -> itemClicked = true
                else -> { }
            }
        }
        viewModel.onItemClick()

        Assert.assertTrue(itemClicked)
    }

    @Test
    fun testInitializationViewModel() {
        val viewModel = ArticleMasterItemViewModel()

        val uri = viewModel.uri.get()
        val title = viewModel.title.get()
        val byLine = viewModel.byLine.get()
        val publishedDate = viewModel.publishedDate.get()

        Assert.assertTrue(uri == "")
        Assert.assertTrue(title == "")
        Assert.assertTrue(byLine == "")
        Assert.assertTrue(publishedDate == "")
    }
}