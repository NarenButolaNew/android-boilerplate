package com.tech.aaranya.data.model;

import java.util.List;

/**
 * Created by test on 3/7/16.
 */
public class DistributorOrders {
    private String id;
    private String distributorId;
    private List<Item> orderItem;
    private String status;
    private double totalAmount;
}
