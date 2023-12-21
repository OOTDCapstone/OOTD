package com.example.capstoneootd.ui.home.homeUi.clothes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.FragmentClothesBinding
import com.example.capstoneootd.ui.adapter.ListAdapterBottom
import com.example.capstoneootd.ui.adapter.ListAdapterShoes
import com.example.capstoneootd.ui.adapter.ListAdapterTop
import com.example.capstoneootd.ui.home.homeUi.home.HomeViewModel

class ClothesFragment : Fragment() {

    private var _binding: FragmentClothesBinding? = null
    private lateinit var listAdapterTop: ListAdapterTop
    private lateinit var listAdapterBottom: ListAdapterBottom
    private lateinit var listAdapterShoes: ListAdapterShoes
    private lateinit var homeViewModel: HomeViewModel


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClothesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        homeViewModel = obtainViewModel(this@ClothesFragment)
        listAdapterTop = ListAdapterTop()
        listAdapterBottom = ListAdapterBottom()
        listAdapterShoes = ListAdapterShoes()

        homeViewModel.getTop(requireContext())
        homeViewModel.getMiddle(requireContext())
        homeViewModel.getBottom(requireContext())

        setUpRecyclerViews()

        getTop()
        getMiddle()
        getBottom()

    }
    private fun setUpRecyclerViews() {
        setUpRvTop()
        setUpRvMid()
        setUpRvBot()
    }

    private fun getTop(){
        homeViewModel.top.observe(requireActivity()){top ->
            listAdapterTop.submitList(top)
        }
    }

    private fun getMiddle(){

        homeViewModel.middle.observe(requireActivity()){middle ->
            listAdapterBottom.submitList(middle)
        }
    }
    private  fun getBottom(){

        homeViewModel.bottom.observe(requireActivity()){bottom ->
            listAdapterShoes.submitList(bottom)
        }
    }

    private fun setUpRvTop(){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvToperHorizontal.layoutManager = layoutManager
        binding.rvToperHorizontal.adapter = listAdapterTop
    }

    private fun setUpRvMid(){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMidHorizontal.layoutManager = layoutManager
        binding.rvMidHorizontal.adapter = listAdapterBottom
    }

    private fun setUpRvBot(){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBottHorizontal.layoutManager = layoutManager
        binding.rvBottHorizontal.adapter = listAdapterShoes
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun obtainViewModel(fragment: Fragment): HomeViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(HomeViewModel::class.java)
    }
}