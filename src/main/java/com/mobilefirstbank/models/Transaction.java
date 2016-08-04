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
package com.mobilefirstbank.models;

import java.util.Date;

public class Transaction {
    public long id;
    public Type type;
    public double amount;
    public Date date;
    public String description;

    public Transaction(long id, Type type, double amount, Date date, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public enum Type {
        CREDIT,
        DEBIT,
        TRANSFER
    }
}