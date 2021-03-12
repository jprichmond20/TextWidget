package edu.coe.richmond.textwidget


import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.widget.RemoteViews
import java.util.*


class RandomWidget : AppWidgetProvider() {
    var random = Random()
    var nums: String? = null
    private val REQUEST_SEND_SMS = 123
    var SMSmgr: SmsManager? = null
    override fun onUpdate(
            context: Context,
            appWidgetManager: AppWidgetManager, appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (appWidget in appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidget)
            SMSmgr = SmsManager.getDefault()
            SMSmgr!!.sendTextMessage("5554", null, "Oi", null, null)
        }
        //SMSmgr = SmsManager.getDefault()
        //SMSmgr!!.sendTextMessage("5554", null, "Oi", null, null)
    }

    fun updateWidget(
            context: Context,
            appWidgetManager: AppWidgetManager, appWidgetId: Int
    ) {

        val r1 = random.nextInt(10)
        val r2 = random.nextInt(10)
        val r3 = random.nextInt(10)
        val nums = "$r1 $r2 $r3"
        val title = "Pick 3"

        val updateViews = RemoteViews(
                context.packageName, R.layout.widget_layout
        )
        updateViews.setTextViewText(R.id.text, title)
        updateViews.setTextViewText(R.id.numbers, nums)

        //Setup the Intent to click on the widget to update.
        val intentUpdate = Intent(context, RandomWidget::class.java)
        intentUpdate.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

        val idArray = intArrayOf(appWidgetId)
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        val pendingUpdate = PendingIntent.getBroadcast(
                context, appWidgetId, intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT)

        updateViews.setOnClickPendingIntent(R.id.wholeWidget, pendingUpdate);


        appWidgetManager.updateAppWidget(appWidgetId, updateViews)
    }



}