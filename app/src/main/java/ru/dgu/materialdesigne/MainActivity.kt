package ru.dgu.materialdesigne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import ru.dgu.materialdesigne.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setSupportActionBar(binding?.topAppBar)


        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.setOnItemSelectedListener{item ->
            when(item.itemId) {
                R.id.homeItemBottomNav -> {supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()}
                R.id.shopItemBottomNav -> {}
                R.id.deliveryItemBottomNav -> {}
                R.id.accountItemBottomNav -> {}
            }
            return@setOnItemSelectedListener true
        }
        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.topAppBar?.setOnMenuItemClickListener{menuItem:MenuItem ->

            when(menuItem.itemId) {
                R.id.favoriteItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Favorite()).commit()

                    true
                }
                R.id.favoriteItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Setting()).commit()

                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflate = menuInflater
        menuInflate.inflate(R.menu.top_menu, menu)

        return true
    }
}