package com.kszerlag.cookbookrest.util;

import org.joda.money.Money;

/**
 * Marker interface
 * for purchasable
 * object like products
 */
public interface Purchasable {

    Money getPrice();

}
