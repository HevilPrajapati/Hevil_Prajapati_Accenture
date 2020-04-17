package com.test.hevil_prajapati.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.hevil_prajapati.repository.DropBoxUserContentRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: DropBoxUserContentRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
