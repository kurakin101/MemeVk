package com.memedev.memeg;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.memedev.memeg.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateActivity extends AppCompatActivity {
//    TextView topText;
//    TextView bottomText;
//    EditText editTop;
//    EditText editBottom;
//    ImageView imageView;
//    ImageView memeImage;
//    Button addButton;
//    Button tryButton;
//    Button saveButton;
//
//    private static  int RESULT_LOAD_IMAGE = 1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_);
//        topText = (TextView)  findViewById(R.id.memeTopText);
//        bottomText = (TextView)  findViewById(R.id.memeBottomText);
//        editTop = (EditText)  findViewById(R.id.editTop);
//        editBottom = (EditText)  findViewById(R.id.editBottom);
//        memeImage = (ImageView)  findViewById(R.id.memeImage);
//        addButton = (Button)  findViewById(R.id.addButton);
//        tryButton = (Button)  findViewById(R.id.tryButton);
//        saveButton = (Button)  findViewById(R.id.saveButton);
//
//
//        tryButton.setVisibility(View.INVISIBLE);
//        saveButton.setVisibility(View.INVISIBLE);
//        editTop.setVisibility(View.INVISIBLE);
//        editBottom.setVisibility(View.INVISIBLE);
//
//
//        android.support.v7.app.ActionBar actoionBar = getSupportActionBar();
//        actoionBar.hide();
//
//
//    }
//
//    public void addImage (View view){
//        Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, RESULT_LOAD_IMAGE);
//    }
//    protected void   onActivityResukt (int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode,resultCode,data);
//
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null!= data){
//            Uri selectedImage = data.getData();
//            String [] filePathColumn = {MediaStore.Images.Media.DATA};
//
//
//            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//
//            ImageView imageView = (ImageView) findViewById(R.id.memeImage);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//        }
//    }
//    public void tryMeme(View view){
//        topText.setText(editTop.getText().toString());
//        bottomText.setText(editBottom.getText().toString());
//        hideKeyboard(view);
//    }
//
//    public void hideKeyboard (View view){
//        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
//
//    }
//
//    public void store(Bitmap bm, String filename){
//        String dirpath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
//        File dir = new File(dirpath);
//        if (!dir.exists()){
//            dir.mkdir();
//        }
//        File file = new File(dirpath,filename);
//        try {
//            FileOutputStream fos = null;
//            fos = new FileOutputStream(file);
//            bm.compress(Bitmap.CompressFormat.PNG,100,fos);
//            fos.flush();
//            fos.close();
//            Toast.makeText(this,"Save",Toast.LENGTH_LONG).show();
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
////    public  static Bitmap getScreen(View view) {
////        view.setDrawingCacheEnabled(true);
////        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
////        view.setDrawingCacheEnabled(false);
////        return bitmap;
////    }
////    public void saveImage (View view) {
////        View content = findViewById(R.id.lay);
////        Bitmap bitmap = getScreen(content);
////        String currentImage = "meme" + System.currentTimeMillis() + ".PNG";
////        store(bitmap,currentImage);
////    }

}



