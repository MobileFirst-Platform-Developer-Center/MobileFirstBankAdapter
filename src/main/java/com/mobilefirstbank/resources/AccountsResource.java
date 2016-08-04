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
import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.OAuthSecurity;
import com.ibm.mfp.server.registration.external.model.AuthenticatedUser;
import com.mobilefirstbank.AccountManager;
import com.mobilefirstbank.models.Account;
import com.mobilefirstbank.models.Transaction;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "Accounts Resource")
@Path("/accounts")
@OAuthSecurity(scope = "restricted")
public class AccountsResource {

    @ApiOperation(value = "Returns user's account list", notes = "A list of accounts that belong to the authenticated user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = Account.class, responseContainer="List")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(AccountManager.getInstance().getAccounts()).build();
    }


    @ApiOperation(value = "Returns all transactions from user's accounts", notes = "A list of transactions from all the accounts belonging to the authenticated user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = Transaction.class, responseContainer="List")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transactions")
    public Response allTransactions() {
        return Response.ok(AccountManager.getInstance().getAllTransactions()).build();
    }

    @ApiOperation(value = "Process check deposits", notes = "Processes the check deposit by using the front and back pictures of the check and then returns a message with the result")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Outcome of the deposit")})
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deposit")
    public Response deposit(@ApiParam(value = "Base64 encoded front image of the check", required = true) @FormParam("front") String base64EncodedFront, @ApiParam(value = "Base64 encoded back image of the check", required = true) @FormParam("back") String base64EncodedBack) {
        JSONObject response = new JSONObject();
        response.put("message", "Your check has been deposited into your account.");

        return Response.ok(response).build();
    }

    @ApiOperation(value = "Process money transfers", notes = "Processes money transfers by using the source and destination accounts in addition to the amount of the transfer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a success message indicating the status of the transfer"),
            @ApiResponse(code = 500, message = "Returns an error message indicating the cause of the transfer failure")
    })
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transfer")
    public Response deposit(@ApiParam(value = "Source account", required = true) @FormParam("src") String from, @ApiParam(value = "Destination account", required = true) @FormParam("dst") String dst, @ApiParam(value = "Transfer amount", required = true) @FormParam("amount") Double amount) {

        JSONObject response = new JSONObject();

        if (amount < 1000) {
            response.put("message", "Money has ben transferred to account " + dst);

            return Response.ok(response).build();
        } else {
            response.put("message", "ERROR: You cannot transfer more than $1000.00");

            return Response.serverError().entity(response.toString()).build();
        }
    }

    @ApiOperation(value = "Returns transactions for a specific account", notes = "A list of transactions for a specific account belonging to the authenticated user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = Transaction.class, responseContainer="List")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response transactions(@ApiParam(value = "Account Number", required = true) @PathParam("id") Long account) {

        return Response.ok(AccountManager.getInstance().getTransactions(account)).build();
    }
}
