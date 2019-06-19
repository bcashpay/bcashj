package org.bcashj.kits;

import org.bcashj.core.Context;
import org.bcashj.core.NetworkParameters;
import org.bcashj.store.BlockStore;
import org.bcashj.store.BlockStoreException;
import org.bcashj.store.LevelDBBlockStore;
import org.bcashj.store.SPVBlockStore;

import java.io.File;

/**
 * Created by Eric on 2/23/2016.
 */
public class LevelDBWalletAppKit extends WalletAppKit {
    public LevelDBWalletAppKit(NetworkParameters params, File directory, String filePrefix) {
        super(params, directory, filePrefix);
    }

    /**
     * Override this to use a {@link BlockStore} that isn't the default of {@link SPVBlockStore}.
     */
    protected BlockStore provideBlockStore(File file) throws BlockStoreException {
        return new LevelDBBlockStore(context, file);
    }
}
