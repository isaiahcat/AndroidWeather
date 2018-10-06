package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseViewHolder;
import com.weather.isaiahj.androidweather.utils.AppLogger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Janisharali on 25-05-2017.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private BulkCurrentWeather mBulkCurrentWeather;

    public WeatherListAdapter(BulkCurrentWeather bulkCurrentWeather) {
        mBulkCurrentWeather = bulkCurrentWeather;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    private boolean hasItems() {
        return mBulkCurrentWeather != null && mBulkCurrentWeather.getList() != null &&
                !mBulkCurrentWeather.getList().isEmpty();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType == VIEW_TYPE_NORMAL ?
                R.layout.item_weather_list_view : R.layout.item_empty_view, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return hasItems() ? VIEW_TYPE_NORMAL : VIEW_TYPE_EMPTY;
    }

    @Override
    public int getItemCount() {
        if (mBulkCurrentWeather != null && !mBulkCurrentWeather.getList().isEmpty()) {
            return mBulkCurrentWeather.getList().size();
        } else {
            return 1;
        }
    }

    public void addItems(BulkCurrentWeather weatherList) {
        mBulkCurrentWeather = weatherList;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onWeatherListEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.title_text_view)
        TextView titleTextView;

        @BindView(R.id.author_text_view)
        TextView authorTextView;

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        @BindView(R.id.content_text_view)
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");
            contentTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

//            final WeatherListResponse.WeatherList WeatherList = mWeatherListResponseList.get(position);
//
//            if (WeatherList.getCoverImgUrl() != null) {
//                Glide.with(itemView.getContext())
//                        .load(WeatherList.getCoverImgUrl())
//                        .asBitmap()
//                        .centerCrop()
//                        .into(coverImageView);
//            }
//
//            if (WeatherList.getTitle() != null) {
//                titleTextView.setText(WeatherList.getTitle());
//            }
//
//            if (WeatherList.getAuthor() != null) {
//                authorTextView.setText(WeatherList.getAuthor());
//            }
//
//            if (WeatherList.getDate() != null) {
//                dateTextView.setText(WeatherList.getDate());
//            }
//
//            if (WeatherList.getDescription() != null) {
//                contentTextView.setText(WeatherList.getDescription());
//            }
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (WeatherList.getWeatherListUrl() != null) {
//                        try {
//                            Intent intent = new Intent();
//                            intent.setAction(Intent.ACTION_VIEW);
//                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                            intent.setData(Uri.parse(WeatherList.getWeatherListUrl()));
//                            itemView.getContext().startActivity(intent);
//                        } catch (Exception e) {
//                            AppLogger.d("url error");
//                        }
//                    }
//                }
//            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onWeatherListEmptyViewRetryClick();
        }
    }
}
