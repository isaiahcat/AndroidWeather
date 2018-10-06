package com.weather.isaiahj.androidweather.ui.main.weatherlist;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.Nullable;

/**
 * Created by isaiahj on 07-10-2018.
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
        return hasItems() ? mBulkCurrentWeather.getList().size() : 1;
    }

    public void addItems(BulkCurrentWeather weatherList) {
        mBulkCurrentWeather = weatherList;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onWeatherListItemClick(CurrentWeather currentWeather);
        void onWeatherListEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

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
            if (itemView != null) itemView.setOnClickListener(null);
        }

        public void onBind(int position) {
            super.onBind(position);

            try {

                final CurrentWeather currentWeather = mBulkCurrentWeather.getList().get(position);

                locationTextView.setText(String.format("%s, %s", currentWeather.getName(),
                        currentWeather.getSys().getCountry()));

                weatherTextView.setText(currentWeather.getWeather().get(0).getDescription());

                temperatureTextView.setText(String.format("%s \u00B0C",
                        currentWeather.getMain().getTemp()));

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCallback.onWeatherListItemClick(currentWeather);
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
            if (mCallback != null)
                mCallback.onWeatherListEmptyViewRetryClick();
        }
    }
}
