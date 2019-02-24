package com.memedev.memeg;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import static android.app.Activity.RESULT_OK;
import static android.content.Context.INPUT_METHOD_SERVICE;


@SuppressLint("ValidFragment")
public class CreateFragment extends Fragment {


    private int Thumbnail ;

    public static final int IMAGE_GALLERY_REQUEST = 20;
    private static final int REQUEST_CODE_SAVE = 44;
    private static final int REQUEST_CODE_CAMERA = 55;
    private static final int REQUEST_CODE_GALLERY = 66;
    private static final int REQUEST_CODE_TAKE_PHOTO = 77;
    private static final int REQUEST_CODE_CHOOSE_PHOTO = 88;
    private static final String[] CAMERA_PERMISSION = {Manifest.permission.CAMERA};
    private static final String[] GALLERY_PERMISSION = {Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final String[] SAVE_PERMISSION = {Manifest.permission.WRITE_EXTERNAL_STORAGE};



    @SuppressLint("ValidFragment")
    public CreateFragment( int thumbnail) {
        Thumbnail = thumbnail;
    }

    View memeLayout;
    ImageView thumbnail;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);
        Button saveButton = (Button) v.findViewById(R.id.saveButton);
        View.OnClickListener saveButtonOnClick = getSaveOnClickListener();
        saveButton.setOnClickListener(saveButtonOnClick);

//
        Toolbar toolbar =  v.findViewById(R.id.toolbar_actionbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

            }
        });

        topText = (TextView)  v.findViewById(R.id.memeTopText);
        bottomText = (TextView)  v.findViewById(R.id.memeBottomText);
        editTop = (EditText)  v.findViewById(R.id.editTop);
        editBottom = (EditText)  v.findViewById(R.id.editBottom);
        memeImage = (ImageView)  v.findViewById(R.id.memeImage);
        tryButton = (Button)  v.findViewById(R.id.tryButton);
        saveButton = (Button)  v.findViewById(R.id.saveButton);
         thumbnail = (ImageView) v.findViewById(R.id.bookthumbnail);
        memeLayout = v.findViewById(R.id.memeLayout);

return v;
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
        boolean storageWritePermissionGranted = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED;
        if (!storageWritePermissionGranted) {
            ActivityCompat.requestPermissions(getActivity(), SAVE_PERMISSION, REQUEST_CODE_SAVE);
        } else {
            saveMeme();
        }
    }

    private void saveMeme() {
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
                MediaScannerConnection.scanFile(getContext(), new String[]{imageFile.getAbsolutePath()}, null, null);
            }
        }
        memeLayout.destroyDrawingCache();
        memeLayout.setDrawingCacheEnabled(false);
        Toast.makeText(getContext(), "Saved to memes folder!", Toast.LENGTH_LONG).show();
    }



    public void addImage (View view){
        Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }


    private void setThumbnail(Bitmap image) {
        thumbnail.setImageBitmap(image);
    }

    public void tryMeme(View view){
        topText.setText(editTop.getText().toString());
        bottomText.setText(editBottom.getText().toString());
        hideKeyboard(view);
    }

    public void hideKeyboard (View view){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),0);

    }

            }
