package org.bcashj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "BCash";
    public static final String coinTicker = "BCASH";
    public static final String coinURIScheme = "bcash";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.bcashpay.org/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://explorer.bcashpay.org/";

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(1 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 60000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 1000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // BCash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70208;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70206;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 2 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 19801;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 19801;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 25;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0x049e04cf;// 0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1519344000L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (1321675);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000002320db441472782a6e357c77a614eb1df4828433804073a404cb66d20cb";//"00000388be243476711fe9e5f80f201c8e9604ca485f2ef0d9dfdadad9e557ff"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "b033fee3e137b49c2573889fef4bea46f01935e8ad1cb7c9da9940b3774e60ea";//"458fffa5899565e4be6252ec1d1defe6cdd4bddb0507f210d31f5fbb20925fc7";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "0000";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "04982b810ee4e5c5804ecfa3bf0a8e1b767f61aa894ab4bf08d959366b516d151b4d7fc507bb3150453c2151631b33c88fddc11a7e7f3ae0e7aadfa15497aa55a6";
    
    //static public String genesisRawTx="01000000010000000000000000000000000000000000000000000000000000000000000000ffffffff03510101ffffffff010080c6a47e8d030023210225e36f1b5bfca5cb1fde72f60b24c7b87d601b33a5291a0baca0af9abcbedaadac00000000";
    static public String genesisRawTx="01000000010000000000000000000000000000000000000000000000000000000000000000ffffffff2d04ffff001d0104255765206372656174652062636173687061792e6f7267206f6e20323031382f30322f32332effffffff0100f2052a01000000434104982b810ee4e5c5804ecfa3bf0a8e1b767f61aa894ab4bf08d959366b516d151b4d7fc507bb3150453c2151631b33c88fddc11a7e7f3ae0e7aadfa15497aa55a6ac00000000";
    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "node1.bcashpay.org",
            "node2.bcashpay.org",
            "node3.bcashpay.org",
            "node4.bcashpay.org"
            
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 76;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 16;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xbf0c6bbd;      //
    public static final String testnetGenesisHash = "000002320db441472782a6e357c77a614eb1df4828433804073a404cb66d20cb";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1519344000L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (1321675);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);//(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.dashdot.io",
            "test.dnsseed.masternode.io",
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  0, Sha256Hash.wrap("000002320db441472782a6e357c77a614eb1df4828433804073a404cb66d20cb"));
        checkpoints.put(  99013, Sha256Hash.wrap("00000000005abcc7fd81d2cd31c759e33a9f72c99e21e485872932fc3f2c02bf"));
        
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "BQpkZFRsfoULgmUhaAQNxiJSV1w2VxvuTx";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDiM3TgBKcxxDKHmrZ8YAQZb6tGJZP2ffHGzaz3rYH1n1uPvDg2w";

}
