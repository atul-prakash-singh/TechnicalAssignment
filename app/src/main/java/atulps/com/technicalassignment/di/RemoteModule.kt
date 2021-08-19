package atulps.com.technicalassignment.di

import atulps.com.technicalassignment.remote.ArticleRemoteService
import atulps.com.technicalassignment.remote.ArticleRemoteServiceImpl
import org.koin.dsl.module.module

/**
 * [remoteModule]
 * @brief This kotlin-koin modules will initialize remote Retrofit Service
 * @author atul.ps
 * @date 03/27/2019
 */
internal val remoteModule = module {

    single<ArticleRemoteService> { ArticleRemoteServiceImpl(get()) }
}
