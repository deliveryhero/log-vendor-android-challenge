package com.deliveryhero.godroid.tech.exam.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.recyclerview.widget.DividerItemDecoration
import com.deliveryhero.godroid.tech.exam.R
import com.deliveryhero.godroid.tech.exam.databinding.MainFragmentBinding
import com.deliveryhero.godroid.tech.exam.ui.main.adapter.OrdersAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val ordersAdapter = OrdersAdapter()

    private var binding: MainFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(LayoutInflater.from(context))
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.mainRecyclerview?.apply {
            adapter = ordersAdapter
            addItemDecoration(getRecyclerViewDividerItem(this.context))
        }
    }

    private fun getRecyclerViewDividerItem(context: Context): DividerItemDecoration {
        val divider = ContextCompat.getDrawable(context, R.drawable.list_divider)!!
        return DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL).apply {
            setDrawable(divider)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
