package com.kolumbo.chinesefoodrecipes.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * WorkManager который будет один раз в день парсить данные и заносить их в room
 * */
class ParseWorkManager(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        // Парсить
        return Result.success()
    }

}