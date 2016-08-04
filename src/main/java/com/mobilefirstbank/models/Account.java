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

import java.util.ArrayList;
import java.util.List;

public class Account {
    public long id;
    public String label;
    public double balance;
    public List<Transaction> transactions;

    public Account(long id, String label, double balance) {
        this.id = id;
        this.label = label;
        this.balance = balance;

        transactions = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

}