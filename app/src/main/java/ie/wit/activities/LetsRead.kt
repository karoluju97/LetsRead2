package ie.wit.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import ie.wit.ImageHelper.readImage
import ie.wit.ImageHelper.selectImage01
import ie.wit.R
import ie.wit.main.LetReadApp
import ie.wit.models.LetsReadModel

import kotlinx.android.synthetic.main.activity_letsread.*
import kotlinx.android.synthetic.main.content_letsread.*

class LetsRead : AppCompatActivity() {

    var letsread = LetsReadModel()
    lateinit var app: LetReadApp

    val IMAGE_REQuEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letsread)
        setSupportActionBar(toolbar)
        app = application as LetReadApp

        btn_post.setOnClickListener()
        {
            letsread.book_name1 = book_title.text.toString()
            letsread.author1 = author.text.toString()
            letsread.genre1 = genre.text.toString()
            letsread.year_released1 = year_released.text.toString()
            letsread.summary1 = summary.text.toString()

            if(letsread.book_name1.isNotEmpty()){
                app.letsread03.add(letsread.copy())
            }
            else{

            }

        }

        add_image.setOnClickListener{
            selectImage01(this,IMAGE_REQuEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            IMAGE_REQuEST->{
                if(data!=null){
                    letsread.image =data.getData().toString()
                    imageView2.setImageBitmap(readImage(this,resultCode,data))
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
