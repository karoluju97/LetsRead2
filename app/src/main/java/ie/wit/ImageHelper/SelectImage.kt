package ie.wit.ImageHelper

import android.app.Activity
import android.content.Intent
import ie.wit.R

fun selectImage01(parent:Activity, id:Int){
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_OPEN_DOCUMENT
    intent.addCategory(Intent.CATEGORY_OPENABLE)
    val chooser = Intent.createChooser(intent, R.string.view_image.toString())
    parent.startActivityForResult(chooser,id)
}