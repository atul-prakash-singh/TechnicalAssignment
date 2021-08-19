package atulps.com.technicalassignment.di

import androidx.room.Room
import atulps.com.technicalassignment.database.RoomArticleDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * [databaseModule]
 * @brief This kotlin-koin modules will initialize database and dao objects
 * @author atul.ps
 * @date 03/27/2019
 */
internal val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            RoomArticleDatabase::class.java, "articles-db"
        ).build()
    }

    single { get<RoomArticleDatabase>().articleDao() }
}
