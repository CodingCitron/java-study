package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.ClubStore;
import io.namoosori.travelclub.spring.store.mapstore.ClubMapStore;
import io.namoosori.travelclub.spring.util.exception.NoSuchClubException;
import io.namoosori.travelclub.spring.util.exception.NoSuchMemberException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clubService")
public class ClubServiceLogic implements ClubService {

    /* IOC 컨테이너를 사용하지 않은 방법 */
    // 인터페이스 타입의 클럽스토어
//    private ClubStore clubStore;
//
//    // 타이트 커플링
//    public ClubServiceLogic() {
//        this.clubStore = new ClubMapStore();
//    }
    /* IOC 컨테이너를 사용하지 않는 방법 */

    /* 빈 사용
    * ClubServiceLogic이 생성되는 시점
    * 생성자를 호출하면서 ApplicationContext.xml 설정 파일 확인 후 ClubMapStore를 주입
    * IOC는 객체의 생성부터 관계 구성까지 대신 해준다.
    * */
    private ClubStore clubStore;

    public ClubServiceLogic(ClubStore clubStore) {
        this.clubStore = clubStore;
    }
    /* 빈 사용 */

    @Override
    public String registerClub(TravelClubCdo club) {
        TravelClub newClub = new TravelClub(club.getName(), club.getIntro());
        newClub.checkValidation();
        return clubStore.create(newClub);
    }

    @Override
    public TravelClub findClubById(String id) {
        return clubStore.retrieve(id);
    }

    @Override
    public List<TravelClub> findClubsByName(String name) {
        return clubStore.retrieveByName(name);
    }

    @Override
    public void modify(String clubId, NameValueList nameValues) {
        TravelClub foundedClub = clubStore.retrieve(clubId);

        if(foundedClub == null) {
            throw new NoSuchMemberException("No such culb with id: " + clubId);
        }

        foundedClub.modifyValues(nameValues);
        clubStore.update(foundedClub);
    }

    @Override
    public void remove(String clubId) {
        if(!clubStore.exists(clubId)) {
            throw new NoSuchClubException("No such club with id: " + clubId);
        }

        clubStore.delete(clubId);
    }
}
