package com.northeastern.edu.simpledb.transport;

import com.google.common.primitives.Bytes;
import com.northeastern.edu.simpledb.common.Error;

import java.util.Arrays;

public class Encoder {

    public byte[] encode(Package pkg) {
        if (pkg.getErr() != null) {
            Exception err = pkg.getErr();
            String msg = "Internal Server Error!";
            if (err.getMessage() != null) {
                msg = err.getMessage();
            }
            return Bytes.concat(new byte[]{1}, msg.getBytes());
        } else  return Bytes.concat(new byte[]{0}, pkg.getData());
    }

    public Package decode(byte[] data) throws Exception {
        if (data.length < 1) throw Error.InvalidPkgDataException;
        else if (data[0] == 0) return new Package(Arrays.copyOfRange(data, 1, data.length), null);
        else if (data[0] == 1) return new Package(null, new RuntimeException(new String(Arrays.copyOfRange(data, 1, data.length))));
        else throw Error.InvalidPkgDataException;
    }
}
