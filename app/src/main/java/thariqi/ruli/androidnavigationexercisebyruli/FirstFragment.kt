package thariqi.ruli.androidnavigationexercisebyruli

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class FirstFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate the layout for this fragment
        val a: View = inflater.inflate(R.layout.fragment_first, container, false)

        bottomNavView = a.findViewById(R.id.bottom_nav_view)

        navHostFragment = childFragmentManager.findFragmentById(R.id.bottom_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        bottomNavView.setupWithNavController(navController)

        return a
    }

}
