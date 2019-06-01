package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class CalculateTest {

    @Test
    public void testCalculation01() {
        final int totalValuesByBOND = Constants.ASSETS.stream()
                .mapToInt(asset -> asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0)
                .sum();
        Assert.assertEquals(3000, totalValuesByBOND);

        final int totalValuesBySTOCK = Constants.ASSETS.stream()
                .mapToInt(asset -> asset.getType() == Asset.AssetType.STOCK ? asset.getValue() : 0)
                .sum();
        Assert.assertEquals(7000, totalValuesBySTOCK);
    }

    @Test
    public void testCalculation02() {
        Assert.assertEquals(10000, totalAssetValues(asset -> true));
        Assert.assertEquals(3000, totalAssetValues(
                asset -> asset.getType() == Asset.AssetType.BOND));
        Assert.assertEquals(7000, totalAssetValues(
                asset -> asset.getType() == Asset.AssetType.STOCK));
    }

    @Test
    public void testCalculation03() {
        final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
        BigDecimal expected = new BigDecimal("6010.00");
        Assert.assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000)
                .compareTo(expected), 0.001);
    }

    @Test
    public void testCalculation04() {
        FluentMailer.send(mailer -> mailer
                .from("build@agiledeveloper.com")
                .to("aaa@aaa.com")
                .subject("build notification")
                .body("...much better..."));
    }

    private int totalAssetValues(final Predicate<Asset> assetSelector) {
        return Constants.ASSETS.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}