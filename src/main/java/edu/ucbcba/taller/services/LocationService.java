package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Location;

/**
 * Created by coreI7 on 30/04/2017.
 */
public interface LocationService {
    Iterable<Location> listAllLocations();

    Location getLocationById(Integer id);

    Location saveLocation(Location location);

    void deleteLocation(Integer id);
}
