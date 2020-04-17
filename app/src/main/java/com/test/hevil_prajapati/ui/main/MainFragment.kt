package com.test.hevil_prajapati.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.hevil_prajapati.R
import com.test.hevil_prajapati.adapter.UserContentAdapter
import com.test.hevil_prajapati.network.ApiService
import com.test.hevil_prajapati.repository.DropBoxUserContentRepository
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {


    private lateinit var factory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = ApiService()
        val repository = DropBoxUserContentRepository(api)
        factory = MainViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.getUserContent()



        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            when {
                it -> progressBar.visibility = GONE
                else -> progressBar.visibility = VISIBLE
            }
        })
        viewModel.userContent.observe(viewLifecycleOwner, Observer { userContent ->
            rvDropBoxUserContent.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = UserContentAdapter(requireContext(), userContent)
            }
        })
    }

}
