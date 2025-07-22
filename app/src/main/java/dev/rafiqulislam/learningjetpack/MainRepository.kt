package dev.rafiqulislam.learningjetpack


import dev.rafiqulislam.learningjetpack.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {
    fun getNumbers(): Flow<Result<Int>> = flow {
        emit(Result.Loading)
        delay(3000)
        try {
            for (i in 1..100) {
                emit(Result.Success(i))
                delay(1000)
                if(i!= 100) {
                    emit(Result.Loading)
                    delay(1000)
                }
            }
        } catch (e: Exception) {
            emit(Result.Error("Failed to fetch numbers: ${e.message}"))
        }
    }
}