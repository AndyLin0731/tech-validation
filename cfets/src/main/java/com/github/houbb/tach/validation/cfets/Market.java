/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tach.validation.cfets;

import java.lang.reflect.Field;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/12 下午6:36  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class Market {

    public static final String ALL                                  = "0";
    public static final String INTER_BANK_OFFERING                  = "1";
    public static final String OUTRIGHT_REPO                        = "10";
    public static final String FXSWP                                = "11";
    public static final String FXSPT                                = "12";
    public static final String FXNDF                                = "13";
    public static final String FXFOW                                = "14";
    public static final String FXIRS                                = "15";
    public static final String BENCHMARK                            = "16";
    public static final String FXCRS                                = "17";
    public static final String CRM                                  = "18";
    public static final String FXOPT                                = "19";
    public static final String INTEREST_RATE_SWAP                   = "2";
    public static final String CNYDEPOSIT                           = "20";
    public static final String FXDEPO                               = "21";
    public static final String CNYLOAN                              = "22";
    public static final String FIXED_DEPOSIT                        = "23";
    public static final String REDEMPTORY_MONETARY_CAPITAL_FOR_SALE = "24";
    public static final String GOLDSPT                              = "25";
    public static final String GOLDFWD                              = "26";
    public static final String GOLDSWP                              = "27";
    public static final String COMMITMENT_DISTRIBUTION_TRANSACTIONS = "28";
    public static final String OPEN_REPO                            = "29";
    public static final String FORWARD_RATE_AGREEMENT               = "3";
    public static final String CAPITAL_TRANSACTIONS                 = "30";
    public static final String WHEN_ISSUED                          = "31";
    public static final String COLLATERAL_REPO_FOR_BILL             = "32";
    public static final String OUTRIGHT_BILL                        = "33";
    public static final String REPO_BILL                            = "34";
    public static final String NON_DELIVERABLE_INTEREST_RATE_SWAP   = "35";
    public static final String NON_DELIVERABLE_OVERNIGHT_INDEX_SWAP = "36";
    public static final String ONSHORE_REPOS                        = "37";
    public static final String OVERNIGHT_INDEX_SWAPS                = "38";
    public static final String CURRENCY_BASIS_SWAP                  = "39";
    public static final String CASH_BOND                            = "4";
    public static final String ADJUST_DATE                          = "40";
    public static final String INTER_BANK_BORROWING                 = "41";
    public static final String STANDARDISED_IRS                     = "42";
    public static final String STANDARD_BOND_FORWARD                = "43";
    public static final String SWAPTION                             = "44";
    public static final String CAP_FLOOR                            = "45";
    public static final String INTERBANK_DEPOSIT_CERTIFICATE        = "47";
    public static final String CREDIT_DEFAULT_SWAPS                 = "48";
    public static final String BJ_GOLD_EXCHANGE                     = "49";
    public static final String BOND_FORWARD                         = "5";
    public static final String EXCHANGE                             = "50";
    public static final String ETF                                  = "51";
    public static final String ASSET_BACKED_SECURITY                = "6";
    public static final String ETFS                                 = "7";
    public static final String SECURITY_LENDING                     = "8";
    public static final String COLLATERAL_REPO                      = "9";
    public static final String FXSWAP                               = "11";
    public static final String FXSPOT                               = "12";
    public static final String FXFWD                                = "14";
    public static final String NEGOTIABLE_CERTIFICATE_OF_DEPOSIT    = "46";

    public static void main(String[] args) {
        trim("CF");
    }

    private static void trim(final String simple) {
        Field[] fields = Market.class.getDeclaredFields();

        for (Field field : fields) {
            String name = field.getName();
            if (fit(simple, name)) {
                System.out.println(name);
            }
        }
    }

    private static boolean fit(final String simple, final String fieldName) {
        char[] chars = simple.toCharArray();

        for (char c : chars) {
            if (!fieldName.contains(c + "")) {
                return false;
            }
        }

        return true;
    }
}
