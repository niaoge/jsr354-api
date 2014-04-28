/*
 * CREDIT SUISSE IS WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE
 * CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS AGREEMENT.
 * PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY
 * DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THE
 * AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY IT, SELECT THE "DECLINE"
 * BUTTON AT THE BOTTOM OF THIS PAGE. Specification: JSR-354 Money and Currency
 * API ("Specification") Copyright (c) 2012-2013, Credit Suisse All rights
 * reserved.
 */
package javax.money.convert;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anatole on 05.03.14.
 */
public class ConversionContextTest{
    @Test
    public void testGetRateType() throws Exception{
        ConversionContext ctx = new ConversionContext.Builder().setRateType(RateType.DEFERRED).create();
        assertEquals(RateType.DEFERRED, ctx.getRateType());
    }

    @Test
    public void testGetProvider() throws Exception{
        ConversionContext ctx = new ConversionContext.Builder().setProvider("myprov").create();
        assertEquals("myprov", ctx.getProvider());
    }

    @Test
    public void testToBuilder() throws Exception{
        ConversionContext ctx = new ConversionContext.Builder().setProvider("myprov").create();
        assertEquals(ctx, ctx.toBuilder().create());
    }

    @Test
    public void testOf() throws Exception{
        ConversionContext ctx = ConversionContext.of();
        ConversionContext ctx2 = ConversionContext.of();
        assertEquals(ctx, ctx2);
    }

    @Test
    public void testOf1() throws Exception{
        ConversionContext ctx = ConversionContext.of(RateType.REALTIME);
        ConversionContext ctx2 = ConversionContext.of(RateType.REALTIME);
        assertEquals(ctx, ctx2);
        assertEquals(RateType.REALTIME, ctx.getRateType());
    }

    @Test
    public void testOf2() throws Exception{
        ConversionContext ctx = ConversionContext.of("prov", RateType.REALTIME);
        ConversionContext ctx2 = ConversionContext.of("prov", RateType.REALTIME);
        assertEquals(ctx, ctx2);
        assertEquals(RateType.REALTIME, ctx.getRateType());
        assertEquals("prov", ctx.getProvider());
    }
}
