package com.kszerlag.cookbookrest.util;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.*;

/**
 * @author kszerlag
 *
 * Special extension of
 * ArrayList designated
 * for containing products
 * to buy
 *
 * @param <T extends Purchasable>
 */
public class ShoppingList<T extends Purchasable> extends ArrayList<T> implements List<T> {

    private static final Currency DEFAULT_CURRENCY = Currency.getInstance(Locale.ENGLISH);

    private final CurrencyUnit currency;

    private Money cost;

    public ShoppingList(CurrencyUnit currency) {
        if (currency == null) {
            currency = CurrencyUnit.of(DEFAULT_CURRENCY);
        }
        this.currency = currency;
        this.cost = Money.zero(currency);
    }

    public ShoppingList(int initialCapacity, CurrencyUnit currency, Money cost) {
        super(initialCapacity);
        if (currency == null) {
            currency = CurrencyUnit.of(DEFAULT_CURRENCY);
        }
        if (cost == null) {
            cost = Money.zero(currency);
        }
        this.currency = currency;
        this.cost = cost;
    }

    @Override
    public boolean add(T t) {
        cost.plus(t.getPrice());
        return super.add(t);
    }

    @Override
    public void add(int index, T element) {
        cost.plus(element.getPrice());
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return super.addAll(c);
    }

    @Override
    public void clear() {
        cost = Money.zero(currency);
        super.clear();
    }

    @Override
    public T remove(int index) {
        cost.minus(get(index).getPrice());
        return super.remove(index);
    }
}
