package com.sesame.learnjetpack.chapter07_WorkManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadLogWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        return Result.success()
    }
}