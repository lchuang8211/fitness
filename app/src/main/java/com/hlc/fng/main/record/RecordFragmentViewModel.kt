package com.hlc.fng.main.record

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hlc.fng.R
import com.hlc.fng.base.BaseViewModel
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.data.source.local.MyDataDao
import com.hlc.fng.domain.record.RecordUseCase
import com.hlc.fng.support.AppUtils
import com.hlc.fng.support.Event
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

class RecordFragmentViewModel @Inject constructor(
    private var MyDataDao: MyDataDao,
    private val recordUseCase: RecordUseCase
) : BaseViewModel() {

    // private var MyDataDao: MyDataDao
    var tv_title = MutableLiveData<String>()
    var drawHeight = MutableLiveData<Float>()
    var drawWidth = MutableLiveData<Float>()
    var drawClickPosition_X = MutableLiveData<Float>()
    var drawClickPosition_Y = MutableLiveData<Float>()
    var sideLength = 20
    var PaintTT = Array(sideLength) { BooleanArray(sideLength) { false } }

    var btnAddImage = MutableLiveData<Boolean>().apply { value = false }
    var btnAddImageEvent = MutableLiveData<Event<Boolean>>()
    var ImgName = MutableLiveData<String>()

    var childFlag = MutableLiveData<Boolean>()


    @RequiresApi(Build.VERSION_CODES.M)
    fun drawClickEvent() {
        var click_X = drawClickPosition_X.value!! / drawWidth.value!!
        var click_Y = drawClickPosition_Y.value!! / drawHeight.value!!
        var percent_X: Int? = null
        var percent_Y: Int? = null
        for (i in 0..sideLength - 1) {
            if (click_X > i / sideLength.toFloat()) {
                percent_X = i
            }
            if (click_Y > i / sideLength.toFloat()) {
                percent_Y = i
            }
        }
        if (click_X < 0F || click_Y < 0F) return
//        Timber.d("比例 $click_X / $click_Y : $percent_X / $percent_Y")
        PaintTT[percent_X!!][percent_Y!!] = true
        Timber.i("1: ${PaintTT[percent_X!!][percent_Y!!]}")
        drawPoint()
    }

    lateinit var bitmap: Bitmap
    var color: Int = 0

    var bitmapEvent = MutableLiveData<Event<Bitmap>>()

    @RequiresApi(Build.VERSION_CODES.M)
    fun drawPoint() {

        bitmap = Bitmap.createBitmap(
            drawWidth.value!!.toInt(),
            drawHeight.value!!.toInt(),
            Bitmap.Config.ARGB_8888
        )
//        Timber.i("2: ${PaintTT[percent_X!!][percent_Y!!]}")
        var paint = Paint()

        paint.isAntiAlias = true
//        Timber.d("比例 : $percent_X / $percent_Y")

//        var rect = Rect()
//        rect.top = percent_Y * (drawHeight.value!! / 10)!!.toInt()
//        rect.bottom = (percent_Y + 1) * (drawHeight.value!! / 10)!!.toInt()
//        rect.left = percent_X * (drawHeight.value!! / 10)!!.toInt()
//        rect.right = (percent_Y + 1) * (drawHeight.value!! / 10)!!.toInt()

        for (i in 0..sideLength - 1) {
            for (j in 0..sideLength - 1) {
                var rect = Rect()
                if (PaintTT[i][j] == true)
                    color = AppUtils.getContext().getColor(R.color.teal)
                else
                    color = AppUtils.getContext().getColor(R.color.white)
                paint.setColor(color)
                rect.top = j * (drawHeight.value!! / sideLength)!!.toInt()
                rect.bottom = (j + 1) * (drawHeight.value!! / sideLength)!!.toInt()
                rect.left = i * (drawWidth.value!! / sideLength)!!.toInt()
                rect.right = (i + 1) * (drawWidth.value!! / sideLength)!!.toInt()
                var cavas = Canvas(bitmap)
                cavas.drawRect(rect, paint)
            }
        }
        bitmapEvent.value = Event(bitmap)

        val file = File(AppUtils.getContext().getFilesDir(), ImgName.value + ".webp")

        Timber.d("path: ${file.toString()}")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, 50, fos)
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        insertImg(
            MyData(
                name = "apple7",
                imageName = ImgName.value!!,
                imageFloor = "55",
                imageUri = file.toURI().toString()
            )
        )
    }

    fun insertImg(data: MyData) {
        recordUseCase.insertImg(data)
    }

    fun btnAddImageClick() {
        btnAddImageEvent.value = Event(true)
    }

    var getImg2 = MutableLiveData<List<MyData>>() // = recordUseCase.getImg()
    var getImg: LiveData<List<MyData>> = recordUseCase.getImg()
    fun getImg() {
//        recordUseCase.getImg()
//        Completable.fromAction { getImg.postValue( recordUseCase.getImg() )}
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()
    }

    fun 一件事() {

        bitmap = Bitmap.createBitmap(
            drawWidth.value!!.toInt(),
            drawHeight.value!!.toInt(),
            Bitmap.Config.ARGB_8888
        )

        recordUseCase.insertImg(
            MyData(
                name = "apple7",
                imageName = ImgName.value!!,
                imageFloor = "55",
                imageUri = File(AppUtils.getContext().getFilesDir(), ImgName.value!! + ".webp").toURI().toString()
            )
        )
    }
}