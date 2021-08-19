package atulps.com.technicalassignment.di

import atulps.com.technicalassignment.viewmodel.ArticleMasterViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * [viewModelModule]
 * @brief This kotlin-koin modules will initialize all viewModels
 * @author atul.ps
 * @date 03/27/2019
 */
internal val viewModelModule = module {

    viewModel { ArticleMasterViewModel(get()) }
}
