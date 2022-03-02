package com.alanchacko.awsimageupload.datastore;

import com.alanchacko.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("1fa345dc-40d3-4382-b8d7-f8fec1ad6e7d"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("5e584549-284e-4aca-b75d-ca358f065631"), "antoniojunior", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
