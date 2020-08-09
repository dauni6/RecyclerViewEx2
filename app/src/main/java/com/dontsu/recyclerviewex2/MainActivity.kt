package com.dontsu.recyclerviewex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val people = arrayListOf<Person>()
        for (i in 0..30) {
            people.add(Person("홍길동 $i", i))
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = PersonAdapter(people) { person: Person ->
                Toast.makeText(this.context, "$person", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
