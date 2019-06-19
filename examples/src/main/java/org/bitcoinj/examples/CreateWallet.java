package org.bitcoinj.examples;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.bcashj.core.Address;
import org.bcashj.core.Base58;
import org.bcashj.core.BlockChain;
import org.bcashj.core.Coin;
import org.bcashj.core.ECKey;
import org.bcashj.core.NetworkParameters;
import org.bcashj.core.Peer;
import org.bcashj.core.PeerAddress;
import org.bcashj.core.PeerGroup;
import org.bcashj.core.Sha256Hash;
import org.bcashj.core.Transaction;
import org.bcashj.kits.WalletAppKit;
import org.bcashj.params.MainNetParams;
import org.bcashj.params.TestNet3Params;
import org.bcashj.store.BlockStore;
import org.bcashj.store.BlockStoreException;
import org.bcashj.store.MemoryBlockStore;
import org.bcashj.wallet.Wallet;
import org.bcashj.wallet.WalletTransaction;

import com.google.common.base.Objects;

//import com.google.common.util.concurrent.ListenableFuture;

public class CreateWallet {

	public static void main(String[] args) throws BlockStoreException, InterruptedException, ExecutionException, UnknownHostException {
		// TODO Auto-generated method stub
		final NetworkParameters params = MainNetParams.get();
		String a = Base58.encode(new byte[] {(byte)76});
//		BlockStore blockStore = new MemoryBlockStore(params);
//	    BlockChain chain = new BlockChain(params, blockStore);
//	    PeerGroup peerGroup = new PeerGroup(params, chain);
//	    peerGroup.start();
//	    // Alternatively you can connect your localhost or another working testnet node
//	    peerGroup.addAddress(new PeerAddress(params, InetAddress.getLocalHost(), params.getPort()));
//	    peerGroup.waitForPeers(1).get();
//	    Peer peer = peerGroup.getConnectedPeers().get(0);
//
//	    Sha256Hash txHash = Sha256Hash.wrap("000000000000f6b6fc7b3a0c7f6dd2842fe355a1ef4f036fbc8ca9cb2a09c551");
//	    ListenableFuture<Transaction> future = peer.getPeerMempoolTransaction(txHash);
//	    System.out.println("Waiting for node to send us the requested transaction: " + txHash);
//	    Transaction tx = future.get();
//	    System.out.println(tx);
		
		
		Wallet wallet = null;
		final File walletFile = new File("D:\\TEMP\\bcash_1.wallet");
		ECKey key = null;
		try {
			wallet = new Wallet(params);
			for(int i = 0; i < 5; i++) {
				key = new ECKey();
				wallet.importKey(key);
			}
			wallet.saveToFile(walletFile);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Unable to create wallet file.");
		}
		ECKey listECKeys0 = wallet.getImportedKeys().get(0);
		ECKey listECKeys1 = wallet.getImportedKeys().get(1);
		ECKey listECKeys2 = wallet.getImportedKeys().get(2);
		ECKey listECKeys3 = wallet.getImportedKeys().get(3);
		ECKey listECKeys4 = wallet.getImportedKeys().get(4);
		Address address = key.toAddress(params);
		
		
		System.out.println("First key in the wallet:\n" + key);
		System.out.println("First key in the wallet:\n" + listECKeys0);
		System.out.println("First key in the wallet:\n" + listECKeys1);
		System.out.println("First key in the wallet:\n" + listECKeys2);
		System.out.println("First key in the wallet:\n" + listECKeys3);
		System.out.println("First key in the wallet:\n" + listECKeys4);
		System.out.println("Complete content of the wallet:\n" + wallet);
		System.out.println("Address :\n" + address);
		
		String publicKey = key.getPublicKeyAsHex();
		String privateKey = key.getPrivateKeyAsHex();
		System.out.println("PublicKey is that :\n" + publicKey);
		System.out.println("PrivateKey is that :\n" + privateKey);
		
		
		if (wallet.isPubKeyHashMine(key.getPubKeyHash())) {
			    System.out.println("Yep, that's my key.");
			} else {
				System.out.println("Nope, that key didn't come from this wallet.");
		}
	}
	
//	  static NetworkParameters params = TestNet3Params.get();
//    static String path = System.getProperty("user.home") + "/Desktop";
//    private static File walletFile = new File(path);
//    private final static String APP_NAME = "MyWallet";
//    private static WalletAppKit kit;
//
//    public static void main(String...args)
//    {
//        kit = new WalletAppKit(params, new File("."), "sendrequest-example")
//        {
//            @Override
//            protected Wallet createWallet() {
//                Wallet wallet = new Wallet(params);
//                return wallet;
//            }
//            @Override
//            protected void onSetupCompleted() {
//                super.onSetupCompleted();
//                System.out.println(kit.wallet().currentReceiveAddress());
//                System.out.println(kit.wallet().getTotalReceived().toFriendlyString());
//                txHistory();
//            }
//        };
//        System.out.println("start syncing...");
//        kit.startAsync();
//        kit.awaitRunning();
//    }
//
//    private static void txHistory()
//    {
//        List<Transaction> txx = kit.wallet().getTransactionsByTime();
//        if (!txx.isEmpty())
//        {
//            int i = 1;
//            for (Transaction tx : txx)
//            {
//                System.out.println(i + "  ________________________");
//                System.out.println("Date and Time: " + tx.getUpdateTime().toString());
//                System.out.println("From Address: " + tx.getOutput(1).getAddressFromP2PKHScript(params));
//                System.out.println("To Address: " + tx.getOutput(0).getAddressFromP2PKHScript(params));
//                System.out.println("Amount Sent to me: " + tx.getValueSentToMe(kit.wallet()).toFriendlyString());
//                System.out.println("Amount Sent from me: " + tx.getValueSentFromMe(kit.wallet()).toFriendlyString());
//                long fee = (tx.getInputSum().getValue() > 0 ? tx.getInputSum().getValue() - tx.getOutputSum().getValue() : 0);
//                System.out.println("Fee: " + Coin.valueOf(fee).toFriendlyString());
//                System.out.println("Transaction Depth: " + tx.getConfidence().getDepthInBlocks());
//                System.out.println("Transaction Blocks: " + tx.getConfidence().toString());
//                System.out.println("Tx Hex: " + tx.getHashAsString());
//                System.out.println("You have " + Coin.FRIENDLY_FORMAT.format(kit.wallet().getBalance()));
//                i++;
//            }
//        }
//        else
//        {
//            System.err.println("No Transaction Found");
//        }
//    }
}
