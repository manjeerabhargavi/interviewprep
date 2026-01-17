package com.javapractice.java8.cardpayment.pojo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

public final class Money {
	private final BigDecimal amount;
	private final Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		this.amount = Objects.requireNonNull(amount, "amount").setScale(2, RoundingMode.HALF_UP);
		this.currency = Objects.requireNonNull(currency, "currency");

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Money add(Money other) {
		requireSameCurrency(other);
		return new Money(this.amount.add(other.amount), this.currency);
	}

	public Money subtract(Money other) {
		requireSameCurrency(other);
		return new Money(this.amount.subtract(other.amount), this.currency);
	}

	private void requireSameCurrency(Money other) {
		if (!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException("Currency Mismatch:" + other.currency + "vs" + this.currency);
		}
	}

	@Override
	public String toString() {
		return amount + " " + currency.getCurrencyCode();
	}
}
