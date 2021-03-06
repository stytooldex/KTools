package com.jiangkang.tools.utils

import android.app.Activity
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log

import com.jiangkang.tools.King

import org.json.JSONObject

import java.util.ArrayList

/**
 * Created by jiangkang on 2017/9/8.
 *
 * 与App相关的工具类
 */

object AppUtils {

    private val TAG = AppUtils::class.java!!.simpleName

    val appVersionName: String
        get() {
            try {
                val packageInfo = packageInfo
                return packageInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return "unknown"
        }


    private val packageInfo: PackageInfo
        @Throws(PackageManager.NameNotFoundException::class)
        get() {
            val pm = King.getApplicationContext().packageManager
            return pm.getPackageInfo(King.getApplicationContext().packageName, PackageManager.GET_CONFIGURATIONS)
        }


    val currentActivity: String
        get() {
            return King.getTopActivityWeakRef().get()!!.componentName.className
        }


    val activityListInStack: List<String>
        get() {
            val activities = King.getsActivityList()
            val list = ArrayList<String>()
            val iterator = activities.iterator()
            while (iterator.hasNext()) {
                val activity = iterator.next() as Activity
                list.add(activity.componentName.className)
            }
            return list
        }



}
