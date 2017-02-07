package com.sherilycoco.shieh.superf.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.ui.widget.CustomDialog;
import com.sherilycoco.shieh.superf.ui.widget.ViewArea;

public class DiaologDemoActivity extends AppCompatActivity {
    private Gallery mGallery;

    private LinearLayout ll_viewArea;
    private LinearLayout.LayoutParams parm;
    private ViewArea viewArea;

    private Integer[] mImage = { R.drawable.guide_page01,
            R.drawable.guide_page02, R.drawable.guide_page03,
            R.drawable.guide_page04 };


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // 去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);

        mGallery = (Gallery) findViewById(R.id.gallery);
        mGallery.setAdapter(new ImageAdapter(this));
        mGallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id)
            {
                Bitmap imageBitmap = drawableToBitmap(getResources().getDrawable(mImage[position]));
                showImg(imageBitmap);
            }
        });
    }


    private void showImg(Bitmap res)
    {
        // 初始化一个自定义的Dialog
        final CustomDialog.Builder b = new CustomDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(DiaologDemoActivity.this);
        final View view = inflater.inflate(R.layout.progress_dialog, null);

        ImageView closeBtn = (ImageView) view.findViewById(R.id.close_btn);

        ll_viewArea = (LinearLayout) view.findViewById(R.id.ll_viewArea);
        parm = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
        parm.gravity = Gravity.CENTER;

        // 自定义布局控件，用来初始化并存放自定义imageView
        viewArea = new ViewArea(DiaologDemoActivity.this, res);

        ll_viewArea.addView(viewArea, parm);

        b.setView(view);
        b.show();

        closeBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                b.dismiss();
            }
        });
    }

    private class ImageAdapter extends BaseAdapter
    {

        private Context mContext;


        public ImageAdapter(Context c)
        {
            mContext = c;
        }


        @Override
        public int getCount()
        {
            return mImage.length;
        }


        @Override
        public Object getItem(int position)
        {
            return position;
        }


        @Override
        public long getItemId(int position)
        {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImage[position]);
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new Gallery.LayoutParams(400, 500));
            return i;
        }
    }


    /**
     * Drawable对象转化Bitmap对象
     * @param drawable Drawable对象
     * @return Bitmap对象
     */
    public Bitmap drawableToBitmap(Drawable drawable)
    {

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE
                        ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        // canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
