package com.demo.menuapp.ui.viewmodel;

import android.app.Application;
import android.location.Location;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.demo.menuapp.data.VenuesRepository;
import com.demo.menuapp.data.mappers.VenueMappers;
import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesItem;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;
import com.demo.menuapp.ui.view.VenueViewItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class VenuesViewModel extends AndroidViewModel {

    private final MutableLiveData<State> state = new MutableLiveData<>(State.IDLE);
    private final MutableLiveData<RepositoryResult<VenuesResponse>> venuesResponse = new MutableLiveData<>();

    private final LiveData<List<VenueViewItem>> venues = Transformations.map(venuesResponse, input -> {
        List<VenueViewItem> items = new ArrayList<>();
        if (input != null && input.getData() != null && input.getData().getData() != null && input.getData().getData().getVenues() != null) {
            for (VenuesItem item : input.getData().getData().getVenues()) {
                items.add(VenueMappers.venueItemToVenueViewItem(getApplication().getResources(), item));
            }
        }
        return items;
    });

    private final VenuesRepository venuesRepository;

    @Inject
    VenuesViewModel(Application application, VenuesRepository venuesRepository) {
        super(application);
        this.venuesRepository = venuesRepository;
    }

    public void onLocationChanged(Location location) {
        venuesRepository.getVenues(location, state, venuesResponse);
    }

    public LiveData<List<VenueViewItem>> getVenues() {
        return venues;
    }

    public LiveData<State> getState() {
        return state;
    }
}
