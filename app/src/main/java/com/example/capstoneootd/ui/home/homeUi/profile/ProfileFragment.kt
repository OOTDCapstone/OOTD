package com.example.capstoneootd.ui.home.homeUi.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.example.capstoneootd.R
import com.example.capstoneootd.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardView: CardView = view.findViewById(R.id.cardview_toDetail)
        cardView.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        startActivity(Intent(activity?.baseContext, DetailProfile::class.java))
    }

}