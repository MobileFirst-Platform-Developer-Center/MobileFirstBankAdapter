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
package com.mobilefirstbank.resources;

import com.ibm.json.java.JSONObject;
import com.ibm.mfp.adapter.api.OAuthSecurity;
import com.ibm.mfp.server.registration.external.model.AuthenticatedUser;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "Appointments Resource")
@Path("/appointments")
@OAuthSecurity(scope = "restricted")
public class AppointmentsResource {

    @ApiOperation(value = "Schedule an appointment", notes = "Processes the scheduling of an appointment based on the date, time, and location")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Returns message indicating the status of the scheduled appointment")})
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@ApiParam(value = "Appointment date", required = true) @FormParam("date") String date, @ApiParam(value = "Appointment time", required = true) @FormParam("time") String time, @ApiParam(value = "Appointment location", required = true) @FormParam("location") String location) {

        JSONObject response = new JSONObject();
        response.put("message", "Your appointment in " + location + " has been scheduled");

        return Response.ok(response).build();
    }

    @ApiOperation(value = "Returns appointment details", notes = "Returns the details of an existing appointment ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Appointment details")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response transactions(@ApiParam(value = "Appointment ID", required = true) @PathParam("id") Long account) {

        JSONObject response = new JSONObject();

        response.put("timestamp", System.currentTimeMillis());
        response.put("location", "Austin, TX");

        return Response.ok(response).build();
    }
}
