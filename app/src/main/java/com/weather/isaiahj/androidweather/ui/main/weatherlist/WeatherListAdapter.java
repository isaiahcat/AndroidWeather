package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseViewHolder;
import com.weather.isaiahj.androidweather.utils.AppLogger;
import com.weather.isaiahj.androidweather.utils.StringUtils;
import com.weather.isaiahj.androidweather.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.Nullable;

/**
 * Created by isaiahj on 07-10-2018.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private BulkCurrentWeather mBulkCurrentWeather;
    private boolean mIsInitialLoad = true;

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
        return mIsInitialLoad || hasItems() ? VIEW_TYPE_NORMAL : VIEW_TYPE_EMPTY;
    }

    @Override
    public int getItemCount() {
        return hasItems() ? mBulkCurrentWeather.getList().size() : mIsInitialLoad ? 3 : 1;
    }

    public void addItems(BulkCurrentWeather weatherList) {
        mIsInitialLoad = false;
        mBulkCurrentWeather = weatherList;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onWeatherListItemClick(CurrentWeather currentWeather, Pair<View, String>... sharedElements);

        void onWeatherListEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @Nullable
        @BindView(R.id.card_view)
        CardView cardView;

        @Nullable
        @BindView(R.id.location_text_view)
        TextView locationTextView;

        @Nullable
        @BindView(R.id.weather_text_view)
        TextView weatherTextView;

        @Nullable
        @BindView(R.id.temperature_text_view)
        TextView temperatureTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            if (locationTextView != null) locationTextView.setText("");
            if (weatherTextView != null) weatherTextView.setText("");
            if (temperatureTextView != null) temperatureTextView.setText("");
            if (cardView != null) cardView.setOnClickListener(null);
        }

        public void onBind(int position) {
            super.onBind(position);

            try {

                final CurrentWeather currentWeather = mBulkCurrentWeather.getList().get(position);

                locationTextView.setText(StringUtils.getFormattedWeatherLocation(currentWeather));

                weatherTextView.setText(StringUtils.getFormattedWeatherDescription(currentWeather));

                temperatureTextView.setText(StringUtils.getFormattedWeatherTemperature(currentWeather));

                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mCallback != null) {
                            mCallback.onWeatherListItemClick(currentWeather,
                                    ViewUtils.getSharedElementPair(cardView),
                                    ViewUtils.getSharedElementPair(locationTextView),
                                    ViewUtils.getSharedElementPair(weatherTextView),
                                    ViewUtils.getSharedElementPair(temperatureTextView));
                        }
                    }
                });

            } catch (NullPointerException exception) {
                AppLogger.d(exception.getMessage());
                clear();
            }

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
            if (mCallback != null) mCallback.onWeatherListEmptyViewRetryClick();
        }
    }
}
