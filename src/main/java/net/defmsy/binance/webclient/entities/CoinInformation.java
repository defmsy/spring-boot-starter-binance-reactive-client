package net.defmsy.binance.webclient.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
public class CoinInformation {

  private final String coin;
  private final Boolean depositAllEnable;
  private final Double free;
  private final Double freeze;
  private final Double ipoable;
  private final Double ipoing;
  private final Boolean isLegalMoney;
  private final Double locked;
  private final String name;
  private final Double storage;
  private final Boolean trading;
  private final Boolean withdrawAllEnable;
  private final Double withdrawing;
  private final List<Network> networkList;

  @JsonCreator
  public CoinInformation(
      @JsonProperty("coin") String coin,
      @JsonProperty("depositAllEnable") Boolean depositAllEnable,
      @JsonProperty("free") Double free,
      @JsonProperty("freeze") Double freeze,
      @JsonProperty("ipoable") Double ipoable,
      @JsonProperty("ipoing") Double ipoing,
      @JsonProperty("isLegalMoney") Boolean isLegalMoney,
      @JsonProperty("locked") Double locked,
      @JsonProperty("name") String name,
      @JsonProperty("storage") Double storage,
      @JsonProperty("trading") Boolean trading,
      @JsonProperty("withdrawAllEnable") Boolean withdrawAllEnable,
      @JsonProperty("withdrawing") Double withdrawing,
      @JsonProperty("networkList") List<Network> networkList) {
    this.coin = coin;
    this.depositAllEnable = depositAllEnable;
    this.free = free;
    this.freeze = freeze;
    this.ipoable = ipoable;
    this.ipoing = ipoing;
    this.isLegalMoney = isLegalMoney;
    this.locked = locked;
    this.name = name;
    this.storage = storage;
    this.trading = trading;
    this.withdrawAllEnable = withdrawAllEnable;
    this.withdrawing = withdrawing;
    this.networkList = networkList;
  }

  @SuppressWarnings("unused")
  public String getCoin() {
    return coin;
  }

  @SuppressWarnings("unused")
  public Boolean getDepositAllEnable() {
    return depositAllEnable;
  }

  @SuppressWarnings("unused")
  public Double getFree() {
    return free;
  }

  @SuppressWarnings("unused")
  public Double getFreeze() {
    return freeze;
  }

  @SuppressWarnings("unused")
  public Double getIpoable() {
    return ipoable;
  }

  @SuppressWarnings("unused")
  public Double getIpoing() {
    return ipoing;
  }

  @SuppressWarnings("unused")
  public Boolean getLegalMoney() {
    return isLegalMoney;
  }

  @SuppressWarnings("unused")
  public Double getLocked() {
    return locked;
  }

  @SuppressWarnings("unused")
  public String getName() {
    return name;
  }

  @SuppressWarnings("unused")
  public Double getStorage() {
    return storage;
  }

  @SuppressWarnings("unused")
  public Boolean getTrading() {
    return trading;
  }

  @SuppressWarnings("unused")
  public Boolean getWithdrawAllEnable() {
    return withdrawAllEnable;
  }

  @SuppressWarnings("unused")
  public Double getWithdrawing() {
    return withdrawing;
  }

  @SuppressWarnings("unused")
  public List<Network> getNetworkList() {
    return networkList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CoinInformation that = (CoinInformation) o;

    return new EqualsBuilder().append(coin, that.coin)
        .append(depositAllEnable, that.depositAllEnable).append(free, that.free)
        .append(freeze, that.freeze).append(ipoable, that.ipoable).append(ipoing, that.ipoing)
        .append(isLegalMoney, that.isLegalMoney).append(locked, that.locked).append(name, that.name)
        .append(networkList, that.networkList).append(storage, that.storage)
        .append(trading, that.trading).append(withdrawAllEnable, that.withdrawAllEnable)
        .append(withdrawing, that.withdrawing).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(coin).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("coin", coin)
        .append("depositAllEnable", depositAllEnable)
        .append("free", free)
        .append("freeze", freeze)
        .append("ipoable", ipoable)
        .append("ipoing", ipoing)
        .append("isLegalMoney", isLegalMoney)
        .append("locked", locked)
        .append("name", name)
        .append("storage", storage)
        .append("trading", trading)
        .append("withdrawAllEnable", withdrawAllEnable)
        .append("withdrawing", withdrawing)
        .append("networkList", networkList)
        .toString();
  }

  @JsonInclude(Include.NON_NULL)
  public static class Network {

    private final String addressRegex;
    private final String coin;
    private final String depositDesc;
    private final Boolean depositEnable;
    private final Boolean isDefault;
    private final String memoRegex;
    private final Long minConfirm;
    private final String name;
    private final String network;
    private final Boolean resetAddressStatus;
    private final String specialTips;
    private final Integer unLockConfirm;
    private final String withdrawDesc;
    private final Boolean withdrawEnable;
    private final Double withdrawFee;
    private final Double withdrawIntegerMultiple;
    private final Double withdrawMax;
    private final Double withdrawMin;
    private final Boolean sameAddress;

    @JsonCreator
    public Network(
        @JsonProperty("addressRegex") String addressRegex,
        @JsonProperty("coin") String coin,
        @JsonProperty("depositDesc") String depositDesc,
        @JsonProperty("depositEnable") Boolean depositEnable,
        @JsonProperty("isDefault") Boolean isDefault,
        @JsonProperty("memoRegex") String memoRegex,
        @JsonProperty("minConfirm") Long minConfirm,
        @JsonProperty("name") String name,
        @JsonProperty("network") String network,
        @JsonProperty("resetAddressStatus") Boolean resetAddressStatus,
        @JsonProperty("specialTips") String specialTips,
        @JsonProperty("unLockConfirm") Integer unLockConfirm,
        @JsonProperty("withdrawDesc") String withdrawDesc,
        @JsonProperty("withdrawEnable") Boolean withdrawEnable,
        @JsonProperty("withdrawFee") Double withdrawFee,
        @JsonProperty("withdrawIntegerMultiple") Double withdrawIntegerMultiple,
        @JsonProperty("withdrawMax") Double withdrawMax,
        @JsonProperty("withdrawMin") Double withdrawMin,
        @JsonProperty("sameAddress") Boolean sameAddress) {
      this.addressRegex = addressRegex;
      this.coin = coin;
      this.depositDesc = depositDesc;
      this.depositEnable = depositEnable;
      this.isDefault = isDefault;
      this.memoRegex = memoRegex;
      this.minConfirm = minConfirm;
      this.name = name;
      this.network = network;
      this.resetAddressStatus = resetAddressStatus;
      this.specialTips = specialTips;
      this.unLockConfirm = unLockConfirm;
      this.withdrawDesc = withdrawDesc;
      this.withdrawEnable = withdrawEnable;
      this.withdrawFee = withdrawFee;
      this.withdrawIntegerMultiple = withdrawIntegerMultiple;
      this.withdrawMax = withdrawMax;
      this.withdrawMin = withdrawMin;
      this.sameAddress = sameAddress;
    }

    @SuppressWarnings("unused")
    public String getAddressRegex() {
      return addressRegex;
    }

    @SuppressWarnings("unused")
    public String getCoin() {
      return coin;
    }

    @SuppressWarnings("unused")
    public String getDepositDesc() {
      return depositDesc;
    }

    @SuppressWarnings("unused")
    public Boolean getDepositEnable() {
      return depositEnable;
    }

    @SuppressWarnings("unused")
    public Boolean getDefault() {
      return isDefault;
    }

    @SuppressWarnings("unused")
    public String getMemoRegex() {
      return memoRegex;
    }

    @SuppressWarnings("unused")
    public Long getMinConfirm() {
      return minConfirm;
    }

    @SuppressWarnings("unused")
    public String getName() {
      return name;
    }

    @SuppressWarnings("unused")
    public String getNetwork() {
      return network;
    }

    @SuppressWarnings("unused")
    public Boolean getResetAddressStatus() {
      return resetAddressStatus;
    }

    @SuppressWarnings("unused")
    public String getSpecialTips() {
      return specialTips;
    }

    @SuppressWarnings("unused")
    public Integer getUnLockConfirm() {
      return unLockConfirm;
    }

    @SuppressWarnings("unused")
    public String getWithdrawDesc() {
      return withdrawDesc;
    }

    @SuppressWarnings("unused")
    public Boolean getWithdrawEnable() {
      return withdrawEnable;
    }

    @SuppressWarnings("unused")
    public Double getWithdrawFee() {
      return withdrawFee;
    }

    @SuppressWarnings("unused")
    public Double getWithdrawIntegerMultiple() {
      return withdrawIntegerMultiple;
    }

    @SuppressWarnings("unused")
    public Double getWithdrawMax() {
      return withdrawMax;
    }

    @SuppressWarnings("unused")
    public Double getWithdrawMin() {
      return withdrawMin;
    }

    @SuppressWarnings("unused")
    public Boolean getSameAddress() {
      return sameAddress;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Network network1 = (Network) o;

      return new EqualsBuilder().append(addressRegex,
              network1.addressRegex).append(coin, network1.coin)
          .append(depositDesc, network1.depositDesc)
          .append(depositEnable, network1.depositEnable).append(isDefault, network1.isDefault)
          .append(memoRegex, network1.memoRegex).append(minConfirm, network1.minConfirm)
          .append(name, network1.name).append(network, network1.network)
          .append(resetAddressStatus, network1.resetAddressStatus)
          .append(specialTips, network1.specialTips).append(unLockConfirm, network1.unLockConfirm)
          .append(withdrawDesc, network1.withdrawDesc)
          .append(withdrawEnable, network1.withdrawEnable)
          .append(withdrawFee, network1.withdrawFee)
          .append(withdrawIntegerMultiple, network1.withdrawIntegerMultiple)
          .append(withdrawMax, network1.withdrawMax).append(withdrawMin, network1.withdrawMin)
          .append(sameAddress, network1.sameAddress).isEquals();
    }

    @Override
    public int hashCode() {
      return new HashCodeBuilder(17, 37).append(coin).append(name).append(network).toHashCode();
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this)
          .append("addressRegex", addressRegex)
          .append("coin", coin)
          .append("depositDesc", depositDesc)
          .append("depositEnable", depositEnable)
          .append("isDefault", isDefault)
          .append("memoRegex", memoRegex)
          .append("minConfirm", minConfirm)
          .append("name", name)
          .append("network", network)
          .append("resetAddressStatus", resetAddressStatus)
          .append("specialTips", specialTips)
          .append("unLockConfirm", unLockConfirm)
          .append("withdrawDesc", withdrawDesc)
          .append("withdrawEnable", withdrawEnable)
          .append("withdrawFee", withdrawFee)
          .append("withdrawIntegerMultiple", withdrawIntegerMultiple)
          .append("withdrawMax", withdrawMax)
          .append("withdrawMin", withdrawMin)
          .append("sameAddress", sameAddress)
          .toString();
    }
  }

}
