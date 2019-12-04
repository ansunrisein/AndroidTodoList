package com.example.androidtodolist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodolist.adapters.Adapter
import com.example.androidtodolist.fragments.CreateBottomDrawerFragment
import com.example.androidtodolist.fragments.EditBottomDrawerFragment
import com.example.androidtodolist.repositories.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        createRecycler()
        fab.setOnClickListener { showBottomDrawer() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createRecycler() {
        val recycleListView: RecyclerView = findViewById(R.id.recyclerview)
        recycleListView.layoutManager = LinearLayoutManager(this)
        recycleListView.adapter = Adapter(Repository.items,
            fun(position: Int): EditBottomDrawerFragment{
                val fragment = EditBottomDrawerFragment(position)
                fragment.show(supportFragmentManager, fragment.tag)

                return fragment
            }
        )
    }

    private fun showBottomDrawer() {
        val bottomNavDrawerFragment = CreateBottomDrawerFragment()
        bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
    }
}
