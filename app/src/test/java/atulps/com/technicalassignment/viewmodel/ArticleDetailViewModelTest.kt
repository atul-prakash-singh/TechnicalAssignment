package atulps.com.technicalassignment.viewmodel

import org.junit.Assert
import org.junit.Test

/**
 * [ArticleDetailViewModelTest]
 * @brief JUnit test class for [ArticleDetailViewModel]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleDetailViewModelTest {

    @Test
    fun testInitializationViewModel() {
        val viewModel = ArticleDetailViewModel()
        val uri = viewModel.uri.get()
        val imageUrl = viewModel.imageUrl.get()
        val detailAbstract = viewModel.detailAbstract.get()
        val title = viewModel.title.get()
        val byLine = viewModel.byLine.get()
        val publishedDate = viewModel.publishedDate.get()

        Assert.assertTrue(uri == "")
        Assert.assertTrue(imageUrl == "")
        Assert.assertTrue(detailAbstract == "")
        Assert.assertTrue(title == "")
        Assert.assertTrue(byLine == "")
        Assert.assertTrue(publishedDate == "")
    }
}
