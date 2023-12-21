package com.example.capstoneootd.ui.home.homeUi.home

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneootd.R
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.data.response.TopRowItem
import com.example.capstoneootd.databinding.FragmentHomeBinding
import com.example.capstoneootd.ui.adapter.ListAdapterBottom
import com.example.capstoneootd.ui.adapter.ListAdapterShoes
import com.example.capstoneootd.ui.adapter.ListAdapterTop
import com.example.capstoneootd.ui.home.homeUi.profile.ProfileViewModel
import com.example.capstoneootd.ui.mashup.MashupActivity
import org.w3c.dom.Text

class HomeFragment : Fragment()  {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var listAdapterTop: ListAdapterTop
    private lateinit var listAdapterBottom: ListAdapterBottom
    private lateinit var listAdapterShoes: ListAdapterShoes
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = obtainViewModel1(this@HomeFragment)
         homeViewModel = obtainViewModel(this@HomeFragment)
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






        binding.ivHelper.setOnClickListener {
            val message : String? = "1. Take photos during the day or in\n" +
                    "        a bright room.\n" +
                    "2. Don’t have the same color\n" +
                    "       background as your item.\n" +
                    "3. Hang your items or lay them out\n" +
                    "       flat.\n" +
                    "4. Avoid other objects in the \n" +
                    "       background."
            showCustomDialogBox(message)
        }
        binding.btnMashup.setOnClickListener{
            startActivity(Intent(activity?.baseContext, MashupActivity::class.java))
        }

        val userId = profileViewModel.getIdUser()
        profileViewModel.getDataUser(userId, context = requireContext())

        profileViewModel.user.observe(requireActivity()){
            binding.textHome.text = it.username
        }

    }

    private fun showCustomDialogBox(message: String?){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_popup_tips)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tv_tips_message)
        val btnOk : Button = dialog.findViewById(R.id.btnok)

        tvMessage.text = message

        val window = dialog.window
        val layoutParams = window?.attributes
        layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams

        btnOk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
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
        binding.rvTopHorizontal.layoutManager = layoutManager
        binding.rvTopHorizontal.adapter = listAdapterTop
    }

    private fun setUpRvMid(){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBottomHorizontal.layoutManager = layoutManager
        binding.rvBottomHorizontal.adapter = listAdapterBottom
    }

    private fun setUpRvBot(){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOtherHorizontal.layoutManager = layoutManager
        binding.rvOtherHorizontal.adapter = listAdapterShoes
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun obtainViewModel(fragment: Fragment): HomeViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(HomeViewModel::class.java)
    }
    private fun obtainViewModel1(fragment: Fragment):ProfileViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(ProfileViewModel::class.java)
    }
}
