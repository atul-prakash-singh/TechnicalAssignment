package atulps.com.technicalassignment.di

import atulps.com.technicalassignment.repository.ArticleRepository
import org.koin.dsl.module.module

/**
 * [repositoryModule]
 * @brief This kotlin-koin modules will initialize [ArticleRepository]
 * @author atul.ps
 * @date 03/27/2019
 */
internal val repositoryModule = module {

    single { ArticleRepository(get()) }
}
