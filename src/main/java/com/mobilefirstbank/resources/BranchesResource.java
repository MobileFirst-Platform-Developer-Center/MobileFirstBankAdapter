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

import com.ibm.mfp.adapter.api.OAuthSecurity;
import com.mobilefirstbank.BranchManager;
import com.mobilefirstbank.models.Branch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "Branches Resource")
@Path("/branches")
@OAuthSecurity(scope = "restricted")
public class BranchesResource {
    @ApiOperation(value = "Returns branches list", notes = "A list of branches")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = Branch.class, responseContainer="List")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(BranchManager.getInstance().getBranches()).build();
    }


    @ApiOperation(value = "Returns branches for appointments", notes = "A list of branches that have appointments available")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", responseContainer="List")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/appointment-locations")
    public Response appointmentLocations() {
        return Response.ok(BranchManager.getInstance().getAppointmentLocations()).build();
    }
}
