package com.example.manifest.Contentproviders

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.manifest.R
import com.example.manifest.databinding.ActivityContentProvidersBinding


class ContentProvidersActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentProvidersBinding
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentProvidersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this
        getContacts()
    }


    @SuppressLint("Range")
    fun getContacts(){
        val Contacts: MutableList<String> = ArrayList()
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
            null,null,null,null)
        if (cursor != null && cursor.moveToFirst()){
            do {
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)) // записывает в переменую список контактов
                Log.d("getContacts","name : $name") // в логах показывает имена всех контактов
                Contacts.add(name)
            }while (cursor.moveToNext())
            cursor.close()
        }
        binding.AutoCompleteTextView.setAdapter(ArrayAdapter(context,android.R.layout.simple_list_item_1,Contacts))
        binding.AutoCompleteTextView.threshold = 1

        binding.AutoCompleteTextView.onItemClickListener = object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(context,
                    "Selected Contact : ${parent?.getItemAtPosition(position)}", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}