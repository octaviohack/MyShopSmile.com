package com.example.myshop.activities.ui.fragments

//import androidx.lifecycle.ViewModelProvider
//import com.example.myshop.activities.ui.dashboard.DashboardViewModel
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.myshop.R
import com.example.myshop.activities.ui.activities.UserProfileActivity
import com.example.myshop.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)



    }


    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(com.example.myshop.R.menu.dashboard_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){

            R.id.actions_settings -> {
                startActivity(Intent(activity,UserProfileActivity::class.java))
                return true
            }

            }

        return super.onOptionsItemSelected(item)

    }


}