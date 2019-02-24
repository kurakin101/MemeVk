package com.memedev.memeg;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BookActivity extends AppCompatActivity {

    public static final int IMAGE_GALLERY_REQUEST = 20;
//    private ImageView bookthumbnail;
    private static final int REQUEST_CODE_SAVE = 44;
    private static final int REQUEST_CODE_CAMERA = 55;
    private static final int REQUEST_CODE_GALLERY = 66;
    private static final int REQUEST_CODE_TAKE_PHOTO = 77;
    private static final int REQUEST_CODE_CHOOSE_PHOTO = 88;
    private static final String[] CAMERA_PERMISSION = {Manifest.permission.CAMERA};
    private static final String[] GALLERY_PERMISSION = {Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final String[] SAVE_PERMISSION = {Manifest.permission.WRITE_EXTERNAL_STORAGE};



    TextView topText;
    TextView bottomText;
    EditText editTop;
    EditText editBottom;
    ImageView imageView;
    ImageView memeImage;
    ImageButton addButton;
    Button tryButton;
    Button saveButton;
    Button doneButton;
    Button ff;
    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    private static  int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);
//        setTitle("Make New Meme");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Button saveButton = (Button) findViewById(R.id.saveButton);
        View.OnClickListener saveButtonOnClick = getSaveOnClickListener();
        saveButton.setOnClickListener(saveButtonOnClick);

//        Bundle extras = getIntent().getExtras();
//        byte[] byteArray = extras.getByteArray("picture");
//        bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//
//        bitmap = rotate(bitmap, 90);
//        ((ImageView) findViewById(R.id.ivForAcceptPicture)).setImageBitmap(bitmap);

//        doneButton  =  findViewById(R.id.doneButton);
//        doneButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intentActivity ();
//
//
//            }
//        });


        Toolbar toolbar =  findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(intent, RESULT_LOAD_IMAGE);

//                    if (PermissionChecker.doIfPermissionGranted(this)) {
//                        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        ActivityUtils.get(this).animateToActivity(i, false, REQUEST_LOAD_GALLERY_IMAGE);
//                    }
//                    return true;

//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_REQUEST);

                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

//                    Intent intent = new Intent(this,BookActivity.class);
//                    startActivity(intent);
            }
        });

//editTop.setVisibility(View.VISIBLE);
//editBottom.setVisibility(View.VISIBLE);
//        bookthumbnail = (ImageView) findViewById(R.id.bookthumbnail);

//        img = (ImageView) findViewById(R.id.bookthumbnail);

        Intent intent = getIntent();
        int image = intent.getExtras().getInt("Thumbnail") ;

//        img.setImageResource(image);

        topText = (TextView)  findViewById(R.id.memeTopText);
        bottomText = (TextView)  findViewById(R.id.memeBottomText);
        editTop = (EditText)  findViewById(R.id.editTop);
        editBottom = (EditText)  findViewById(R.id.editBottom);
        memeImage = (ImageView)  findViewById(R.id.memeImage);
//        addButton = (ImageButton)  findViewById(R.id.addButton);
        tryButton = (Button)  findViewById(R.id.tryButton);
        saveButton = (Button)  findViewById(R.id.saveButton);

//
//        android.support.v7.app.ActionBar actoionBar = getSupportActionBar();
//        actoionBar.hide();

//
//        tryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                editBottom.setVisibility(View.INVISIBLE);
////                editTop.setVisibility(View.INVISIBLE);
//            }
//        });
//        ff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(this, DoneActivity.class);
//                intent.putExtra("fname",meme);
//                intent.putExtra("lname", image);
//
//
//                startActivity(intent);
//
//            }
//        });
    }
//ImageView tutu;
//        public  void intentActivity (){
//            tutu = findViewById(R.id.tutu);
//            Intent intent = new Intent(this, DoneActivity.class);
//            View memeLayout = findViewById(R.id.memeLayout);
//                intent.putExtra("lname", memeLayout);
//            tutu.setImageBitmap(memeLayout);
//
//
//                startActivity(intent);
//}

    ImageView bookthumbnail;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {




        bookthumbnail = (ImageView) findViewById(R.id.bookthumbnail);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_GALLERY_REQUEST) {
                Uri imageUri = data.getData();

                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    bookthumbnail.setImageBitmap(image);

//                    Intent intent = new Intent(this, BookActivity.class);
//                    intent.putExtra("fname",imageUri);
//                    intent.putExtra("lname", image);
//
//
//                    startActivity(intent);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to load image", Toast.LENGTH_LONG).show();
                }

//                picUri = data.getData();
//                // кадрируем его
//                performCrop();
//            }
//            // Вернулись из операции кадрирования
//            else if(requestCode == PIC_CROP){
//                Bundle extras = data.getExtras();
//                // Получим кадрированное изображение
//                Bitmap thePic = extras.getParcelable("data");
//                // передаём его в ImageView
//                ImageView picView = (ImageView)findViewById(R.id.picture);
//                picView.setImageBitmap(thePic);
//            }
        }
//        EditText topTextInput = (EditText) findViewById(R.id.topTextInput);
//
//        String top = topTextInput.getText().toString();
//
//        TextView meme1 = (TextView) findViewById(R.id.meme1);
//
//        meme1.setText(top);
//
//
//        EditText bottomTextInput = (EditText) findViewById(R.id.bottomTextInput);
//
//        String bottom = bottomTextInput.getText().toString();
//
//        TextView meme2 = (TextView) findViewById(R.id.meme2);
//
//        meme2.setText(bottom);

    }
}


    private View.OnClickListener getSaveOnClickListener() {
        View.OnClickListener saveOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterSaveMemeFlow();
            }
        };

        return saveOnClickListener;
    }

    private void enterSaveMemeFlow() {
        boolean storageWritePermissionGranted = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED;
        if (!storageWritePermissionGranted) {
            ActivityCompat.requestPermissions(this, SAVE_PERMISSION, REQUEST_CODE_SAVE);
        } else {
            saveMeme();
        }
    }

    private void saveMeme() {
        View memeLayout = findViewById(R.id.memeLayout);
        memeLayout.setDrawingCacheEnabled(true);
        memeLayout.buildDrawingCache();
        Bitmap full = memeLayout.getDrawingCache();
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            File imageFolder = new File(Environment.getExternalStorageDirectory(), "memes");
            imageFolder.mkdirs();
            FileOutputStream out = null;
            File imageFile = new File(imageFolder, String.valueOf(System.currentTimeMillis()) + ".png");
            try {
                out = new FileOutputStream(imageFile);
                full.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                out = null;
                MediaScannerConnection.scanFile(this, new String[]{imageFile.getAbsolutePath()}, null, null);
            }
        }
        memeLayout.destroyDrawingCache();
        memeLayout.setDrawingCacheEnabled(false);
        Toast.makeText(this, "Saved to memes folder!", Toast.LENGTH_LONG).show();
    }



    public void addImage (View view){
        Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }
    protected void   onActivityResukt (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null!= data){
            Uri selectedImage = data.getData();
            String [] filePathColumn = {MediaStore.Images.Media.DATA};


            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            ImageView imageView = (ImageView) findViewById(R.id.bookthumbnail);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        /**
//         * Step 3
//         */
//        if (requestCode == REQUEST_CODE_TAKE_PHOTO && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            setThumbnail(imageBitmap);
//        }
//        /**
//         * Step 4
//         */
//        else if (requestCode == REQUEST_CODE_CHOOSE_PHOTO && resultCode == RESULT_OK) {
//            Uri imageUri = data.getData();
//            try {
//                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
//                setThumbnail(image);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private void setThumbnail(Bitmap image) {
        ImageView thumbnail = (ImageView) findViewById(R.id.bookthumbnail);
        thumbnail.setImageBitmap(image);
    }

    public void tryMeme(View view){
        topText.setText(editTop.getText().toString());
        bottomText.setText(editBottom.getText().toString());
        hideKeyboard(view);
    }

    public void hideKeyboard (View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

    }

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
//            Toast.makeText(this,"Save", Toast.LENGTH_LONG).show();
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public  static Bitmap getScreen(View view) {
//        view.setDrawingCacheEnabled(true);
//        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
//        view.setDrawingCacheEnabled(false);
//        return bitmap;
//    }
//    public void saveImage (View view) {
//        View content = findViewById(R.id.lay);
//        Bitmap bitmap = getScreen(content);
//        String currentImage = "meme" + System.currentTimeMillis() + ".PNG";
//        store(bitmap,currentImage);
//    }




}



