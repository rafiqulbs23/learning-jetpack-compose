package dev.rafiqulislam.learningjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rafiqulislam.learningjetpack.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private  val repository: MainRepository =MainRepository()) : ViewModel() {
    private val _num = MutableStateFlow<Result<Int>>(Result.Loading)
    val num: Flow<Result<Int>> = _num

    init {
        viewModelScope.launch {
            repository.getNumbers().collect {
                _num.value = it
            }
        }
    }
}