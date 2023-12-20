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
import com.example.capstoneootd.R
import com.example.capstoneootd.databinding.FragmentHomeBinding
import com.example.capstoneootd.ui.adapter.ListAdapterTop
import com.example.capstoneootd.ui.mashup.MashupActivity
import org.w3c.dom.Text

class HomeFragment : Fragment()  {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var listAdapterTop: ListAdapterTop
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
         val adapter = ListAdapterTop()
        binding.rvTopHorizontal.adapter = adapter



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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}