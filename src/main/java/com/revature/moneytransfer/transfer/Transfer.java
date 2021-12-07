package com.revature.moneytransfer.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSFERS")
public class Transfer {

    @Id
    @GeneratedValue
    private int id;
    private int fromId;
    private int toId;
    private double amount;
    private String concept;
    private String locator;

}
