package com.codecrew.fantasticket.entities;

import com.codecrew.fantasticket.entities.users.Customer;

import javax.persistence.*;

public class FantasticWallet {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private int id;

    @Column(name = "balance")
    private  double balance;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
