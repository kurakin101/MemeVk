package com.memedev.memeg;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;



import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.memedev.memeg.BookActivity.IMAGE_GALLERY_REQUEST;

public class GaleryActivity extends AppCompatActivity {


    private static final int PICK_REQUEST = 53;

    List<Book> lstBook ;



        TextView topText;
        TextView bottomText;
        EditText editTop;
        EditText editBottom;
        ImageView imageView;
        ImageView memeImage;
        ImageButton addButton;
        Button tryButton;
        Button saveButton;


        private static  int RESULT_LOAD_IMAGE = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.galery_activity);

//            topText = (TextView)  findViewById(R.id.memeTopText);
//            bottomText = (TextView)  findViewById(R.id.memeBottomText);
            editTop = (EditText)  findViewById(R.id.editTop);
            editBottom = (EditText)  findViewById(R.id.editBottom);
            memeImage = (ImageView)  findViewById(R.id.memeImage);
//            addButton = (ImageButton)  findViewById(R.id.addButton);
            tryButton = (Button)  findViewById(R.id.tryButton);
            saveButton = (Button)  findViewById(R.id.saveButton);



            lstBook = new ArrayList<>();
            lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.re));
            lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.aaa));
            lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.as));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.b));
            lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.c));
            lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.cvv));
            lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.ddd));
            lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.df));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.dfg));
            lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.e));
            lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.eee));
            lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.er));
            lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.fff));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.fg));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.gh));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.h));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hhh));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hhhh));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hj));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.i));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.ii));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.io));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.j));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.kl));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.l));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.m));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.mm));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.n));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.o));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.op));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.pa));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.ppp));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.q));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.qqq));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.qw));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.rrr));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.rt));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.rty));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.s));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.sd));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.ttt));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.ty));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.ui));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.v));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.vvv));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.we));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.xxx));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.yu));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.yy));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.z));
            lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.zxc));

//            RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
//            RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
//            myrv.setLayoutManager(new GridLayoutManager(this,2));
//            myrv.setAdapter(myAdapter);


//
//            android.support.v7.app.ActionBar actoionBar = getSupportActionBar();
//            actoionBar.hide();


//            Toolbar toolbar =  findViewById(R.id.toolbar_actionbar);
//            setSupportActionBar(toolbar);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
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

//                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                    File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//                    String pictureDirectoryPath = pictureDirectory.getPath();
//                    Uri data = Uri.parse(pictureDirectoryPath);
//                    photoPickerIntent.setDataAndType(data, "image/*");
//                    startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
//
////                    Intent intent = new Intent(this,BookActivity.class);
////                    startActivity(intent);
//                }
//            });



        }

//    ImageView free1;
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//
//
//
//        free1 = (ImageView) findViewById(R.id.free1);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == IMAGE_GALLERY_REQUEST) {
//                Uri imageUri = data.getData();
//
//                InputStream inputStream;
//                try {
//                    inputStream = getContentResolver().openInputStream(imageUri);
//                    Bitmap image = BitmapFactory.decodeStream(inputStream);
//                    free1.setImageBitmap(image);
//
//                        Intent intent = new Intent(this, BookActivity.class);
//                        intent.putExtra("fname",imageUri);
//                        intent.putExtra("lname", image);
//
//
//                    startActivity(intent);
//
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                    Toast.makeText(this, "Unable to load image", Toast.LENGTH_LONG).show();
//                }
//
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
//            }
//            EditText topTextInput = (EditText) findViewById(R.id.topTextInput);
//
//            String top = topTextInput.getText().toString();
//
//            TextView meme1 = (TextView) findViewById(R.id.meme1);
//
//            meme1.setText(top);
//
//
//            EditText bottomTextInput = (EditText) findViewById(R.id.bottomTextInput);
//
//            String bottom = bottomTextInput.getText().toString();
//
//            TextView meme2 = (TextView) findViewById(R.id.meme2);
//
//            meme2.setText(bottom);
//
//        }
//    }

//    public void onImageGalleryClicked(View v) {
//        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        String pictureDirectoryPath = pictureDirectory.getPath();
//        Uri data = Uri.parse(pictureDirectoryPath);
//        photoPickerIntent.setDataAndType(data, "image/*");
//        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
//
//
//    }


//    private void initViews() {
//        ImageView imgGallery;
//
//
//
//        imgGallery = findViewById(R.id.toolbar_actionbar);
//        imgGallery.setOnClickListener((View.OnClickListener) this);
//
//    }


//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.imgPencil:
//                mPhotoEditor.setBrushDrawingMode(true);
//                mTxtCurrentTool.setText(R.string.label_brush);
//                mPropertiesBSFragment.show(getSupportFragmentManager(), mPropertiesBSFragment.getTag());
//                break;
//            case R.id.btnEraser:
//                mPhotoEditor.brushEraser();
//                mTxtCurrentTool.setText(R.string.label_eraser);
//                break;
//            case R.id.imgText:
//                TextEditorDialogFragment textEditorDialogFragment = TextEditorDialogFragment.show(this);
//                textEditorDialogFragment.setOnTextEditorListener(new TextEditorDialogFragment.TextEditor() {
//                    @Override
//                    public void onDone(String inputText, int colorCode) {
//                        mPhotoEditor.addText(inputText, colorCode);
//                        mTxtCurrentTool.setText(R.string.label_text);
//                    }
//                });
//                break;
//
//            case R.id.imgUndo:
//                mPhotoEditor.undo();
//                break;
//
//            case R.id.imgRedo:
//                mPhotoEditor.redo();
//                break;
//
//            case R.id.imgSave:
//                saveImage();
//                break;
//
//            case R.id.imgClose:
//                if (!mPhotoEditor.isCacheEmpty()) {
//                    showSaveDialog();
//                } else {
//                    finish();
//                }
//                break;
//
//            case R.id.imgSticker:
//                mStickerBSFragment.show(getSupportFragmentManager(), mStickerBSFragment.getTag());
//                break;
//
//            case R.id.imgEmoji:
//                mEmojiBSFragment.show(getSupportFragmentManager(), mEmojiBSFragment.getTag());
//                break;
//
//            case R.id.imgCamera:
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//                break;

//            case R.id.toolbar_actionbar:
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_REQUEST);

//                Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, RESULT_LOAD_IMAGE);
//                break;
//        }
//    }


    //        public void addImage (View view){
//            Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(intent, RESULT_LOAD_IMAGE);
//        }
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


                ImageView imageView = (ImageView) findViewById(R.id.memeImage);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }
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

        public void store(Bitmap bm, String filename){
            String dirpath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
            File dir = new File(dirpath);
            if (!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dirpath,filename);
            try {
                FileOutputStream fos = null;
                fos = new FileOutputStream(file);
                bm.compress(Bitmap.CompressFormat.PNG,100,fos);
                fos.flush();
                fos.close();
                Toast.makeText(this,"Save",Toast.LENGTH_LONG).show();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

//        public  static Bitmap getScreen(View view) {
//            view.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
//            view.setDrawingCacheEnabled(false);
//            return bitmap;
//        }
//        public void saveImage (View view) {
//            View content = findViewById(R.id.lay);
//            Bitmap bitmap = getScreen(content);
//            String currentImage = "meme" + System.currentTimeMillis() + ".PNG";
//            store(bitmap,currentImage);
//        }

    }
