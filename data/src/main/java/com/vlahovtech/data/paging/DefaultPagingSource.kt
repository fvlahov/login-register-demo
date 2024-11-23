package com.vlahovtech.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vlahovtech.domain.model.Page
import retrofit2.HttpException
import java.io.IOException

class DefaultPagingSource<T : Any>(
    private val fetchPageProducer: suspend (page: Int, pageSize: Int) -> Page<T>,
) : PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        //for first case it will be null, then we can pass some default value, in our case it's 1
        val page = params.key ?: 1
        return try {
            val response = fetchPageProducer(page, params.loadSize)
            LoadResult.Page(
                response.items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.items.isEmpty()) null else response.nextPage
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}