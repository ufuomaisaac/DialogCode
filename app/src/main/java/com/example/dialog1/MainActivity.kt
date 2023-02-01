package com.example.dialog1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var contactDialog = AlertDialog.Builder(this)
            .setTitle("Contact Dialog")
            .setIcon(R.drawable.person_add_24)
            .setMessage("Do you want to add mr Poop's contact")
            .setPositiveButton("Yes", DialogInterface.OnClickListener{
                _, _ -> Toast.makeText(this, "Mr Poop's contact was successfully added",Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener{
                _, _ -> Toast.makeText(this, "Mr Poop's contact was not added",Toast.LENGTH_SHORT).show()
            }).create()

        binding.btnDialog1.setOnClickListener {
            contactDialog.show()
        }

        var options = arrayOf("FirstItem", "SecondItem", "ThirdItem")
        var singleAlertDialog = AlertDialog.Builder(this)
            .setTitle("Select one of these options")
            .setSingleChoiceItems(options, -1 , DialogInterface.OnClickListener{
                Dialog, i -> Toast.makeText(this, "you selected ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            .setPositiveButton("Accept", DialogInterface.OnClickListener{
                dialog,i -> Toast.makeText(this, "singleAlertDialog was Accepted ",Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Decline", DialogInterface.OnClickListener{
                dialog, i->  Toast.makeText(this, "singleAlertDialog was declined ",Toast.LENGTH_SHORT).show()
            }).create()

        binding.btnDialog2.setOnClickListener {
            singleAlertDialog.show()
        }


        var optionss = arrayOf("FirstItem", "SecondItem", "ThirdItem")
        var multipleAlertDialog = AlertDialog.Builder(this)
            .setTitle("Select your option(s)")
            .setMultiChoiceItems(optionss, booleanArrayOf(false, false, false), DialogInterface.OnMultiChoiceClickListener{
                dialog, i, ischecked ->
                if(ischecked) {
                    Toast.makeText(this, "you checked ${optionss[i]}",Toast.LENGTH_SHORT).show()
                }  else
                    Toast.makeText(this, "you unchecked ${optionss[i]}",Toast.LENGTH_SHORT).show()
            })
            .setPositiveButton("Accept", DialogInterface.OnClickListener{
                    dialog,i -> Toast.makeText(this, "singleAlertDialog was Accepted ",Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Decline", DialogInterface.OnClickListener{
                    dialog, i->  Toast.makeText(this, "singleAlertDialog was declined ",Toast.LENGTH_SHORT).show()
            }).create()

        binding.btnDialog3.setOnClickListener {
            multipleAlertDialog.show()
        }

    }
}