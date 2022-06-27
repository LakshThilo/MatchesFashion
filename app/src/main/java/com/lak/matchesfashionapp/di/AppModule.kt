package com.lak.matchesfashionapp.di

import com.lak.matchesfashionapp.data.remote.apiservice.MatchesFashionAPI
import com.lak.matchesfashionapp.reposotory.ProductRepo
import com.lak.matchesfashionapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   /* @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): ProductDatabase {
        return ProductDatabase.invoke(context)
    }

    @Singleton
    @Provides
    fun getDao(database: ProductDatabase): ProductDao {
        return database.getProductDao()
    }*/

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providePokeApi(retrofit: Retrofit): MatchesFashionAPI {
        return retrofit.create(MatchesFashionAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        api: MatchesFashionAPI
    ) = ProductRepo(api)

}