package com.memedev.memeg;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.memedev.memeg.MemeActivity.IMAGE_GALLERY_REQUEST;


public class GalleryFragment extends Fragment {

    private static final int PICK_REQUEST = 53;
private Fragment mFragment;
    List<Meme> lstBook ;



    TextView topText;
    TextView bottomText;
    EditText editTop;
    EditText editBottom;
    ImageView imageView;
    ImageView memeImage;
    ImageButton addButton;
    Button tryButton;
    Button saveButton;
    ImageView ddr;


    private static  int RESULT_LOAD_IMAGE = 20;

    public GalleryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        topText = (TextView)  v.findViewById(R.id.memeTopText);
        editTop = (EditText)  v.findViewById(R.id.editTop);
        editBottom = (EditText)  v.findViewById(R.id.editBottom);
        memeImage = (ImageView)  v.findViewById(R.id.memeImage);
        tryButton = (Button)  v.findViewById(R.id.tryButton);
        saveButton = (Button)  v.findViewById(R.id.saveButton);
        ddr = (ImageView) v.findViewById(R.id.bookthumbnail);





        lstBook = new ArrayList<>();
        lstBook.add(new Meme("The Vegitarian","Categorie Book","Description book",-1));
        lstBook.add(new Meme("The Vegitarian","Categorie Book","Description book",R.drawable.re));
        lstBook.add(new Meme("The Wild Robot","Categorie Book","Description book",R.drawable.aaa));
        lstBook.add(new Meme("Maria Semples","Categorie Book","Description book",R.drawable.as));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.b));
        lstBook.add(new Meme("The Vegitarian","Categorie Book","Description book",R.drawable.c));
        lstBook.add(new Meme("The Wild Robot","Categorie Book","Description book",R.drawable.cvv));
        lstBook.add(new Meme("Maria Semples","Categorie Book","Description book",R.drawable.ddd));
        lstBook.add(new Meme("The Martian","Categorie Book","Description book",R.drawable.df));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.dfg));
        lstBook.add(new Meme("The Vegitarian","Categorie Book","Description book",R.drawable.e));
        lstBook.add(new Meme("The Wild Robot","Categorie Book","Description book",R.drawable.eee));
        lstBook.add(new Meme("Maria Semples","Categorie Book","Description book",R.drawable.er));
        lstBook.add(new Meme("","Categorie Book","Description book",R.drawable.fff));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.fg));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.gh));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.h));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.hhh));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.hhhh));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.hj));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.i));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.ii));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.io));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.j));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.kl));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.l));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.m));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.mm));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.n));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.o));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.op));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.pa));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.ppp));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.q));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.qqq));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.qw));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.rrr));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.rt));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.rty));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.s));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.sd));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.ttt));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.ty));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.ui));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.v));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.vvv));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.we));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.xxx));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.yu));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.yy));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.z));
        lstBook.add(new Meme("He Died with...","Categorie Book","Description book",R.drawable.zxc));





        RecyclerView myrv =  v.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter((AppCompatActivity) getActivity(),this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);

        myrv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        });


        return v;
    }


    public void   onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);





        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
           Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};


            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ddr.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

}
