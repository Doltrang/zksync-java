package io.zksync.domain.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.zksync.domain.Signature;
import io.zksync.domain.TimeRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Withdraw implements ZkSyncTransaction {

    private final String type = "Withdraw";

    private Integer accountId;

    private String from;

    private String to;

    private Integer token;

    private BigInteger amount;

    private String fee;

    private Integer nonce;

    private Signature signature;

    @JsonUnwrapped
    private TimeRange timeRange;

    @JsonIgnore
    public BigInteger getFeeInteger() {
        return new BigInteger(fee);
    }
}
