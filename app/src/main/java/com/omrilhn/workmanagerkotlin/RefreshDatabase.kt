package com.omrilhn.workmanagerkotlin

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        val getData = inputData//Get input data
        val myNumber = getData.getInt("intKey",0) //Get data from MainActivity
        refreshDatabase(myNumber) //Call refresh database
        return Result.success()
    }
    private fun refreshDatabase(myNumber : Int)
    {
        //Get small amount but crucial data by SharedPreferences down below
        val sharedPreferences = context.getSharedPreferences("com.omrilhn.workmanagerkotlin",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber = mySavedNumber + myNumber
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply()

    }

}