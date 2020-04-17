package com.test.hevil_prajapati.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.hevil_prajapati.model.Row
import com.test.hevil_prajapati.network.Coroutines
import com.test.hevil_prajapati.repository.DropBoxUserContentRepository
import kotlinx.coroutines.Job

class MainViewModel(
    private val repository: DropBoxUserContentRepository
) : ViewModel() {

    private lateinit var job: Job
    private val _userContent = MutableLiveData<List<Row>>()
    val userContent: LiveData<List<Row>>
        get() = _userContent
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    init {
        _isLoading.value = false
    }

    fun getUserContent() {
        job = Coroutines.ioThenMain(
            { repository.getDropBoxUserContent() },
            {
                _userContent.value = it?.rows
                _isLoading.value = true
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
