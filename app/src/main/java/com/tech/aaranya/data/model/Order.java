package com.tech.aaranya.data.model;

import java.util.Date;
import java.util.List;

/**
 * Created by test on 3/7/16.
 */
public class Order {
    List<DistributorOrders> distributorOrderses;
    private String id;
    private String customerId;
    private Date registrationDate;
    private Date requestedDate;
    private Date deliveryDate;
    private String orderCreatedBy;
    private String orderAssignedTo;
    private String orderDeliveredBy;

}
