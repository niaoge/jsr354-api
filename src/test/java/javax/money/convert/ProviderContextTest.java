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

import static org.junit.Assert.*;

/**
 * Created by Anatole on 05.03.14.
 */
public class ProviderContextTest{

    @Test
    public void testGetRateTypes() throws Exception{
        ProviderContext ctx = new ProviderContext.Builder("myprov").setRateTypes(RateType.DEFERRED, RateType.HISTORIC).create();
        assertEquals("myprov", ctx.getProviderName());
    }

    @Test
    public void testToBuilder() throws Exception{
        ProviderContext ctx = new ProviderContext.Builder("myprov").create();
        assertEquals(ctx, ctx.toBuilder().create());
    }

    @Test
    public void testOf() throws Exception{
        ProviderContext ctx = ProviderContext.of("testprov");
        ProviderContext ctx2 = ProviderContext.of("testprov");
        assertEquals(ctx, ctx2);
        assertEquals("testprov", ctx.getProviderName());
    }

    @Test
    public void testOfWithRateType() throws Exception{
        ProviderContext ctx = ProviderContext.of("test", RateType.REALTIME);
        ProviderContext ctx2 = ProviderContext.of("test", RateType.REALTIME);
        assertEquals(ctx, ctx2);
        assertNotNull(ctx.getRateTypes());
        assertTrue(ctx.getRateTypes().size()==1);
        assertTrue(ctx.getRateTypes().contains(RateType.REALTIME));
    }

    @Test
    public void testFrom() throws Exception{
        ConversionContext cc = new ConversionContext.Builder().setProvider("Myprov").setRateType(RateType.REALTIME).create();
        ProviderContext ctx = ProviderContext.from(cc);
        ProviderContext ctx2 = ProviderContext.from(cc);
        assertEquals(ctx, ctx2);
        assertTrue(ctx.getRateTypes().contains(RateType.REALTIME));
        assertEquals("Myprov", ctx.getProviderName());
    }
}
