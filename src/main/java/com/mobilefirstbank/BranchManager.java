/*
 *  © Copyright 2016 IBM Corp.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mobilefirstbank;

import com.mobilefirstbank.models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BranchManager {
    private static BranchManager instance;

    public static BranchManager getInstance() {
        if (instance == null) {
            instance = new BranchManager();
        }

        return instance;
    }

    private List<Branch> branches = new ArrayList<Branch>();

    private BranchManager() {
        branches.add(new Branch("NAL3456", "2412 E Desert Inn Rd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.130143, -115.1181))));
        branches.add(new Branch("NAL6751", "2430 E Flamingo Rd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.115088, -115.118125))));
        branches.add(new Branch("NAL9880", "129 Fremont St, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.170614, -115.144702))));
        branches.add(new Branch("NAL8731", "4780 S Maryland Pkwy, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.102964, -115.136572))));
        branches.add(new Branch("NAL1053", "300 S Fourth St, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.166884, -115.14395))));
        branches.add(new Branch("NAL4009", "2585 S Nellis Blvd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.143048, -115.065881))));
        branches.add(new Branch("NAL6480", "3805 E Flamingo Rd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.115033, -115.091627))));
        branches.add(new Branch("NAL4331", "3200 S Las Vegas Blvd G-5, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.127424, -115.170815))));
        branches.add(new Branch("NAL6186", "591 N Eastern Ave #110, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.173637, -115.116721))));
        branches.add(new Branch("NAL2009", "2233 Paradise Rd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.143971, -115.154371))));
        branches.add(new Branch("NAL2409", "145 E Harmon Ave, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.107589, -115.166615))));
        branches.add(new Branch("NAL2419", "840 S Rancho Dr, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.161719, -115.173133))));
        branches.add(new Branch("NAL2967", "855 S Grand Central Pkwy, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.163675, -115.157212))));
        branches.add(new Branch("NAL9867", "2000 S Las Vegas Blvd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.14732, -115.155234))));
        branches.add(new Branch("NAL9768", "3300 Las Vegas Blvd S, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.126703, -115.169448))));
        branches.add(new Branch("NAL8037", "5715 S Eastern Ave, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.085725, -115.119514))));
        branches.add(new Branch("NAL7736", "4001 S Maryland Pkwy, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.116634, -115.139187))));
        branches.add(new Branch("NAL5561", "3475 S Las Vegas Blvd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.119834, -115.172168))));
        branches.add(new Branch("NAL5449", "3755 Spring Mountain Road, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.125948, -115.189491))));
        branches.add(new Branch("NAL8860", "3150 Paradise Rd, Las Vegas, NV, United States", new Branch.Geometry(new Location(36.131291, -115.152772))));
    }


    public Collection<Branch> getBranches() {
        return branches;
    }

    public Collection<String> getAppointmentLocations() {

        List<String> locations = new ArrayList<String>();

        locations.add("Austin, TX");
        locations.add("Charlotte, NC");
        locations.add("Chicago, IL");
        locations.add("Houston, TX");
        locations.add("Los Angeles, CA");
        locations.add("Miami, FL");
        locations.add("New York, NY");
        locations.add("Orlando, FL");
        locations.add("Phoenix, AZ");
        locations.add("Raleigh, NC");
        locations.add("San Francisco, CA");

        return locations;
    }
}
