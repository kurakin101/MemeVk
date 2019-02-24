package com.memedev.memeg;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.util.List;
import static com.memedev.memeg.MemeActivity.IMAGE_GALLERY_REQUEST;


/**
 * Created by Vasiliy on 14.04.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private FragmentActivity myContext;
    private static  int RESULT_LOAD_IMAGE = 1;
    private AppCompatActivity mActivity ;
    private Fragment mFragment;
    private List<Meme> mData ;


    public RecyclerViewAdapter(AppCompatActivity mActivity, Fragment mFragment, List<Meme> mData) {
        this.mActivity = mActivity;
        this.mFragment = mFragment;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        view = mInflater.inflate(viewType, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if( mData.get(position).getThumbnail() == -1){
            return R.layout.add_layout;
        }else{
            return R.layout.cardveiw_item_meme;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if( mData.get(position).getThumbnail() == -1){
            holder.add.setImageResource(R.drawable.ic_gallery);
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    String pictureDirectoryPath = pictureDirectory.getPath();
                    Uri data = Uri.parse(pictureDirectoryPath);
                    photoPickerIntent.setDataAndType(data, "image/*");
                    mFragment.startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);


                }
            });
        }else{
            holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int thumbnail = position;
                    CreateFragment fragment2 = new CreateFragment(thumbnail);
                    FragmentTransaction fragmentTransaction2 = mActivity.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.framgmentConstainer, fragment2);  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction2.commit();


                }
            });
        }
    }

    protected void   showPicture (View itemView,String picturePath){
            ImageView imageView = (ImageView) itemView.findViewById(R.id.bookthumbnail);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
    }


            @Override
            public int getItemCount () {
                return mData.size();
            }

            public static class MyViewHolder extends RecyclerView.ViewHolder {

                TextView tv_book_title;
                ImageView img_book_thumbnail;
                ImageView add;
                CardView cardView;
                CardView cardView1;
                ImageView imageView;

                public MyViewHolder(View itemView) {
                    super(itemView);

                    img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
                    add = (ImageView) itemView.findViewById(R.id.ad_gallery_image);
                    cardView = (CardView) itemView.findViewById(R.id.cardview_id);
                    cardView1 = (CardView) itemView.findViewById(R.id.ad_view_id);
                     imageView = (ImageView) itemView.findViewById(R.id.bookthumbnail);



                }
            }




}

