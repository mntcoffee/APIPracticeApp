package com.example.apipracticeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.apipracticeapp.R
import com.example.apipracticeapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        // navigation set up
        val navView: BottomNavigationView = binding.bottomNavBar
        val navController = findNavController(R.id.fragmentContainerView2)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.rankingFragment, R.id.accountFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Tabの切り替え以外のFragmentの時はBottomNavigationを非表示にする
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.rankingFragment -> navView.visibility = View.VISIBLE
                R.id.accountFragment -> navView.visibility = View.VISIBLE
                else -> navView.visibility = View.GONE
            }
        }

    }

    // リポジトリ詳細画面からupButtonで戻れるようにする
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView2)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}