package com.example.capstoneootd.ui.home.homeUi.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.capstoneootd.R
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.FragmentHomeBinding
import com.example.capstoneootd.databinding.FragmentProfileBinding
import com.example.capstoneootd.ui.home.homeUi.clothes.ClothesViewModel
import com.example.capstoneootd.ui.home.homeUi.home.HomeViewModel
import com.example.capstoneootd.ui.signIn.SignInViewModel
import com.example.capstoneootd.ui.signUp.SignUpViewModel
import kotlin.math.log


class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cardView: CardView = view.findViewById(R.id.cardview_toDetail)
        cardView.setOnClickListener(this)

        profileViewModel = obtainViewModel(this@ProfileFragment)

        val userId = profileViewModel.getIdUser()
        profileViewModel.getDataUser(userId, context = requireContext())


        val imageUrl = "https://i.pinimg.com/originals/c9/e3/e8/c9e3e810a8066b885ca4e882460785fa.jpg"

        Glide.with(this)
            .load(imageUrl)
            .into(binding.tvProfilePhoto)

        profileViewModel.user.observe(requireActivity()){
            binding.tvNameProfile.text = it.username
        }



    }

    override fun onClick(v: View?) {
        startActivity(Intent(activity?.baseContext, DetailProfile::class.java))
    }

    private fun obtainViewModel(fragment: Fragment):ProfileViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(ProfileViewModel::class.java)



    }
}