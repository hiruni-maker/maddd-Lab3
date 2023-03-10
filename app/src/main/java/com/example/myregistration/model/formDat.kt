package com.example.myregistration.model

class formDat (private var studentID:String, var year:String, var semester:String,
               private  var agree:Boolean,){


    fun validateStudentID(): ValidationResult {

        return if(studentID.isEmpty())
        {
            ValidationResult.Empty(" student id is empty")
        }
        else if(!studentID.startsWith("IT"))
        {
            ValidationResult.Invalid("Invalid the enter digits")
        }
        else if(studentID.length!=10)
        {
            ValidationResult.Invalid("Student id should have 10 charactoers")
        }
        else{
            ValidationResult.Valid
        }
    }
    fun validateYear(): ValidationResult {
        return if(year.isEmpty())
        {
            ValidationResult.Empty("Year is Empty")
        }
        else
        {
            ValidationResult.Valid
        }


    }

    fun validateSemester(): ValidationResult {

        return if(year.isEmpty())
        {
            ValidationResult.Empty("Semester is Empty")
        }
        else
        {
            ValidationResult.Valid
        }

    }
    fun validateAgreement(): ValidationResult {

        return if(year.isEmpty())
        {
            ValidationResult.Empty("you must agree for the teams and conditions")
        }
        else
        {
            ValidationResult.Valid
        }

    }

}