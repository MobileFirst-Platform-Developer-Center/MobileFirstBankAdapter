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

import com.mobilefirstbank.models.Account;
import com.mobilefirstbank.models.Transaction;

import java.util.*;

public class AccountManager {
    private static AccountManager instance;

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }

        return instance;
    }

    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    private AccountManager() {
        Account checking = new Account(9102844850L, "Checking Account", 4205.88);
        checking.addTransaction(new Transaction(109372739045L, Transaction.Type.CREDIT, 560.90, new Date(), "Branch Deposit"));
        checking.addTransaction(new Transaction(912092473884L, Transaction.Type.CREDIT, 2304.62, new Date(), "Incoming Wire Transfer"));
        checking.addTransaction(new Transaction(923763475927L, Transaction.Type.DEBIT, -3999.29, new Date(), "Outgoing Wire Transfer"));
        checking.addTransaction(new Transaction(198392647324L, Transaction.Type.DEBIT, -30.00, new Date(), "Wire Transfer Fee"));
        checking.addTransaction(new Transaction(982426439847L, Transaction.Type.DEBIT, -798.15, new Date(), "Credit Card Payment"));
        checking.addTransaction(new Transaction(928374651339L, Transaction.Type.CREDIT, 9830.67, new Date(), "Check Deposit"));
        checking.addTransaction(new Transaction(982426439847L, Transaction.Type.DEBIT, -848, new Date(), "Online Purchase"));

        Account savings = new Account(9782930497L, "Savings Account", 205890.29);

        savings.addTransaction(new Transaction(745749494059L, Transaction.Type.TRANSFER, 3455.45, new Date(), "Transfer from Checking"));
        savings.addTransaction(new Transaction(912092473884L, Transaction.Type.CREDIT, 45.02, new Date(), "Interest Payment"));
        savings.addTransaction(new Transaction(892734657383L, Transaction.Type.DEBIT, -1500.02, new Date(), "Transfer to Checking"));
        savings.addTransaction(new Transaction(733057548304L, Transaction.Type.TRANSFER, 4500, new Date(), "Transfer from Checking"));
        savings.addTransaction(new Transaction(129093203928L, Transaction.Type.TRANSFER, 393.76, new Date(), "Transfer from Checking"));
        savings.addTransaction(new Transaction(283744775883L, Transaction.Type.CREDIT, 46.59, new Date(), "Interest Payment"));


        Account moneyMarket = new Account(2930894874L, "Money Marker Account", 50130.45);

        moneyMarket.addTransaction(new Transaction(937472882837L, Transaction.Type.TRANSFER, 3455.45, new Date(), "Transfer from Checking"));
        moneyMarket.addTransaction(new Transaction(122990298483L, Transaction.Type.CREDIT, 45.02, new Date(), "Interest Payment"));
        moneyMarket.addTransaction(new Transaction(169388589840L, Transaction.Type.DEBIT, -1500.02, new Date(), "Transfer to Checking"));
        moneyMarket.addTransaction(new Transaction(376355199380L, Transaction.Type.TRANSFER, 4500, new Date(), "Transfer from Checking"));
        moneyMarket.addTransaction(new Transaction(103884853003L, Transaction.Type.TRANSFER, 393.76, new Date(), "Transfer from Checking"));
        moneyMarket.addTransaction(new Transaction(183935777595L, Transaction.Type.CREDIT, 46.59, new Date(), "Interest Payment"));


        accounts.put(checking.id, checking);
        accounts.put(savings.id, savings);
        accounts.put(moneyMarket.id, moneyMarket);
    }


    public Collection<Account> getAccounts() {
        return accounts.values();
    }


    public List<Transaction> getTransactions(long accountId) {
        return accounts.get(accountId).getTransactions();
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> all = new ArrayList<Transaction>();

        for (Account account : accounts.values()) {
            all.addAll(account.getTransactions());
        }

        return all;
    }
}
