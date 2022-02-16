package InformaticsTest;

/**
 * Created by IntelliJ IDEA
 * Date: 19.05.2021
 * Time: 4:33 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Data {
    private String clubId;
    private String playerId;
    // in months
    private int contractLength;
    private String contractExpiryDate;

    public String getClubId() {
        return clubId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getContractLength() {
        return contractLength;
    }

    public String getContractExpiryDate() {
        return contractExpiryDate;
    }

    public Data(String clubId, String playerId, int contractLength, String contractExpiryDate) {
        this.clubId = clubId;
        this.playerId = playerId;
        this.contractLength = contractLength;
        this.contractExpiryDate = contractExpiryDate;
    }

    public static Data fromArray(String[] arr){
        return new Data(arr[1],arr[0],Integer.parseInt(arr[2]),arr[3]);
    }
}
