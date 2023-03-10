package com.example.myregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.myregistration.model.ValidationResult
import com.example.myregistration.model.formDat

class MainActivity : AppCompatActivity() {

    lateinit var editStudentID:EditText
    lateinit var spnYear:Spinner
    lateinit var spnSemester:Spinner
    lateinit var cbAgree:CheckBox
    lateinit var btnSubmit: Button
    private var  count =0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

        override fun onResume(){

            super.onResume()
            btnSubmit.setOnClickListener(View.OnClickListener{

                 count =0;
                val  myForm= formDat(editStudentID.text.toString(),
                    spnYear.selectedItem.toString(),
                    spnSemester.selectedItem.toString(),
                    cbAgree.isChecked)

                val studentIDValidation = myForm.validateStudentID()
                val yearValidation = myForm.validateYear()
                val semesterValidation = myForm.validateSemester()
                val agreeValidation = myForm.validateAgreement()

                when(studentIDValidation){

                    is ValidationResult.Valid->{
                        //valid
                    }
                    is ValidationResult.Invalid->{
                        editStudentID.error=studentIDValidation.errorMessage
                    }
                    is ValidationResult.Empty->{
                       editStudentID.error=studentIDValidation.errorMessage
                    }

                }

                when(yearValidation){

                    is ValidationResult.Valid->{

                    }
                    is ValidationResult.Invalid->{
                        val tv:TextView=spnYear.selectedView as TextView
                        tv.error=""
                        tv.text=yearValidation.errorMessage

                    }
                    is ValidationResult.Empty->{

                    }

                }

                if(count==4)
                {
                    displayalert("")
                }




            })


        }




}