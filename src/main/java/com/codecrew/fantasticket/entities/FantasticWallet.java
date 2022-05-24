package com.codecrew.fantasticket.entities;

import com.codecrew.fantasticket.entities.users.User;

import javax.persistence.*;

public class FantasticWallet {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private int id;

    @Column(name = "balance")
    private  double balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User customer;
}
